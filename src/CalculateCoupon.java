import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateCoupon {
    private static final Map<String, String> childParentCategory = new HashMap<>();
    private static final Map<String, String> categoryCoupons = new HashMap<>();
    private static final Map<String, List<LFUCache.Pair<String, String>>> categoryDiscounts = new HashMap<String, List<LFUCache.Pair<String, String>>>();
    private static final LocalDate today = LocalDate.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    static String[][] coupons = {
    {"CategoryName:Comforter Sets", "CouponName:Comforters Sale"},
    {"CategoryName:Bedding", "CouponName:Savings on Bedding"},
    {"CategoryName:Bed & Bath", "CouponName:Low price for Bed & Bath"}};

    static String[][] coupons1 = {
            {"CategoryName:Comforter Sets", "CouponName:Comforters Sale", "DateModified:2020-01-01"},
            {"CategoryName:Comforter Sets", "CouponName:Cozy Comforter Coupon", "DateModified:2020-01-01"},
            {"CategoryName:Bedding", "CouponName:Best Bedding Bargains", "DateModified:2019-01-01"},
            {"CategoryName:Bedding", "CouponName:Savings on Bedding", "DateModified:2019-01-01"},
            {"CategoryName:Bed & Bath", "CouponName:Low price for Bed & Bath", "DateModified:2018-01-01"},
            {"CategoryName:Bed & Bath", "CouponName:Bed & Bath extravaganza", "DateModified:2019-01-01"},
            {"CategoryName:Bed & Bath", "CouponName:Big Savings for Bed & Bath", "DateModified:2030-01-01"}
    };

    static String[][] coupons2 = {
            {"CategoryName:Comforter Sets", "CouponName:Comforters Sale", "DateModified:2020-01-01", "Discount:10%"},
            {"CategoryName:Comforter Sets", "CouponName:Cozy Comforter Coupon", "DateModified:2020-01-01", "Discount:$15"},
            {"CategoryName:Bedding", "CouponName:Best Bedding Bargains", "DateModified:2019-01-01", "Discount:35%"},
            {"CategoryName:Bedding", "CouponName:Savings on Bedding", "DateModified:2019-01-01", "Discount:25%"},
            {"CategoryName:Bed & Bath", "CouponName:Low price for Bed & Bath", "DateModified:2018-01-01", "Discount:50%"},
            {"CategoryName:Bed & Bath", "CouponName:Bed & Bath extravaganza", "DateModified:2019-01-01", "Discount:75%"}
    };

    static String[][] products = {
            {"ProductName:Cozy Comforter Sets", "Price:100.00", "CategoryName:Comforter Sets"},
            {"ProductName:All-in-one Bedding Set", "Price:50.00", "CategoryName:Bedding"},
            {"ProductName:Infinite Soap Dispenser", "Price:500.00", "CategoryName:Bathroom Accessories"},
            {"ProductName:Rainbow Toy Box", "Price:257.00", "CategoryName:Baby And Kids"}
    };

    static String[][] categories = {
    {"CategoryName:Comforter Sets", "CategoryParentName:Bedding"},
    {"CategoryName:Bedding", "CategoryParentName:Bed & Bath"},
    {"CategoryName:Bed & Bath", "CategoryParentName:None"},
    {"CategoryName:Soap Dispensers", "CategoryParentName:Bathroom Accessories"},
    {"CategoryName:Bathroom Accessories", "CategoryParentName:Bed & Bath"},
    {"CategoryName:Toy Organizers", "CategoryParentName:Baby And Kids"},
    {"CategoryName:Baby And Kids", "CategoryParentName:None"}};

    static String[] inputs = {
            "Comforter Sets",
            "Bedding",
            "Bathroom Accessories",
            "Soap Dispensers",
            "Toy Organizers"
    };

    static String[] input2 = {
            "Bed & Bath",
            "Bedding",
            "Bathroom Accessories",
            "Comforter Sets"
    };


    public static String parse(String s) {
        return s.split(":")[1];
    }

    public static void main(String[] args) {
        /***
         * Requirements/Acceptance Criteria:
         *
         * Create a function that when passed a Category Name (as a String) will return Coupon Name (as a String)
         * Category structure is hierarchical. Categories without coupons inherit their parent’s coupon.
         * No coupon should be returned if there are no coupons in the Category’s hierarchy
         * For example: Toy Organizers receives no coupon because there is no coupon in the category hierarchy.
         * If a Category has a coupon it should not move up the hierarchy to find its Parent Category (or the Parent’s Coupon)
         * For example: Comforter sets, should see the coupon for Comforter Sets and NOT Bedding
         *
         * Beware of the following examples/edge cases and their expected behaviours:
         * Bathroom Accessories should receive the coupon for Bed & Bath because there are no coupons for Bathroom Accessories
         * Assumption: Product can only be associated with one category.
         */
        for (String[] category: categories) {
            childParentCategory.put(parse(category[0]), parse(category[1]));
        }
        preComputeCoupon1(coupons, categories);
        for (String input: inputs) {
            System.out.println(getCoupons(input));
        }
        System.out.println("************************************\n");

        /**
         * The system has added a new piece of data to the coupon — “Date Modified”. Use this when resolving any ties (when 1 Category
         * has 2+ Coupons
         */
        preComputeCoupon2(coupons1, categories);
        for (String input : input2) {
            System.out.println(getCoupons(input));
        }
        System.out.println("************************************\n");

        /**
         * The function should now return the discounted price. The coupon array now has discount and we also have list of product
         */
        preComputeCoupan3(coupons2, categories, products);
        for (String[] product : products) {
            System.out.println(getDiscountedPrice(product));
        }
    }


    public static String getCoupons(String categoryName) {
        return categoryCoupons.get(categoryName);
    }

    public static void preComputeCoupon1(String[][] coupons, String[][] categories) {
        Map<String, List<String>> tempMap = new HashMap<>();
        for (String[] coupon: coupons) {
            tempMap.computeIfAbsent(parse(coupon[0]), i -> new ArrayList<>()).add(parse(coupon[1]));
        }
        for (String[] category: categories) {
            String parentCategory = preComputeWithParent(parse(category[0]), tempMap);
            if (parentCategory != null) {
                categoryCoupons.put(parse(category[0]), String.join(" | ", tempMap.get(parentCategory)));
            }
        }
    }

    private static String preComputeWithParent(String s, Map<String, List<String>> tempMap) {
        if (s ==null || s.equals("None") || !childParentCategory.containsKey(s)) {
            return null;
        }
        if (tempMap.containsKey(s)) return s;
        String parent = childParentCategory.get(s);
        return preComputeWithParent(parent, tempMap);
    }

    public static void preComputeCoupon2(String[][] coupons, String[][] categories) {
        /**
         * Map of category Vs Map of Date and list of couponCode*/
        Map<String, Map<String, List<String>>> tempMap = new HashMap<>();
        for (String[] coupon: coupons) {
            tempMap.computeIfAbsent(parse(coupon[0]), k-> new TreeMap<>(Comparator.reverseOrder()))
                    .computeIfAbsent(parse(coupon[2]), k -> new ArrayList<>())
                    .add(parse(coupon[1]));
        }

        for (Map.Entry<String, Map<String, List<String>>> entry : tempMap.entrySet()) {
            String category = entry.getKey();
            for (Map.Entry<String, List<String>> dateEntry:  entry.getValue().entrySet()) {
                if (!LocalDate.parse(dateEntry.getKey(), formatter).isAfter(today)) {
                    categoryCoupons.put(category, String.join(" | ", dateEntry.getValue()));
                    break;
                }
            }
        }

        for (String[] category: categories) {
            String parentCategory = preComputeWithParent2(parse(category[0]), tempMap);
            if (parentCategory!=null) {
                categoryCoupons.put(parse(category[0]), categoryCoupons.get(parentCategory));
            }
        }
    }

    private static String preComputeWithParent2(String s, Map<String, Map<String, List<String>>> tempMap) {
        if (s ==null || s.equals("None") || !childParentCategory.containsKey(s)) {
            return null;
        }
        if (tempMap.containsKey(s)) return s;
        String parent = childParentCategory.get(s);
        return preComputeWithParent2(parent, tempMap);
    }

    private static void preComputeCoupan3(String[][] coupons2, String[][] categories, String[][] products) {
        /**
         * Map of category Vs Map of Date and list of couponCodes and discount
         * */
        Map<String, Map<String, List<LFUCache.Pair<String, String>>>> tempMap = new HashMap<>();
        for (String[] coupon: coupons2) {
            tempMap.computeIfAbsent(parse(coupon[0]), k-> new TreeMap<>(Comparator.reverseOrder()))
                    .computeIfAbsent(parse(coupon[2]), k -> new ArrayList<>())
                    .add(new LFUCache.Pair<>(parse(coupon[1]), parse(coupon[3])));
        }
        for (Map.Entry<String, Map<String, List<LFUCache.Pair<String, String>>>> entry : tempMap.entrySet()) {
            String category = entry.getKey();
            for (Map.Entry<String, List<LFUCache.Pair<String, String>>> dateEntry:  entry.getValue().entrySet()) {
                if (!LocalDate.parse(dateEntry.getKey(), formatter).isAfter(today)) {
                    categoryDiscounts.put(category, dateEntry.getValue());
                    break;
                }
            }
        }
        for (String[] category: categories) {
            String parentCategory = preComputeWithParent3(parse(category[0]), tempMap);
            if (parentCategory!=null) {
                categoryCoupons.put(parse(category[0]), categoryCoupons.get(parentCategory));
            }
        }

        // pre compute discounted price for products
        for (String[] product: products) {
            String category = parse(product[2]);
            double price = Double.parseDouble(parse(product[1]));
            List<LFUCache.Pair<String, String>> discounts = categoryDiscounts.get(category);
            if (discounts != null) {
                StringBuilder sb = new StringBuilder();
                for (LFUCache.Pair<String, String> discount: discounts) {
                    if (discount.second.contains("%")) {
                        Matcher matcher = Pattern.compile("(\\d{1,3})%").matcher(discount.second);
                        if (matcher.find()) {
                            double percentage = Double.parseDouble(matcher.group(1));
                            double discountedPrice = price * (1-percentage/100);
                            sb.append(String.format("%.2f", discountedPrice)).append(" OR ");
                        }
                    } else if (discount.second.contains("$")) {
                        BigDecimal discountValue = new BigDecimal(discount.second.substring(1));
                        BigDecimal discountedPrice = BigDecimal.valueOf(price).subtract(discountValue).setScale(2, RoundingMode.HALF_UP);
                        sb.append(String.format("%.2f", discountedPrice)).append(" OR ");
                    }
                }
                if (sb.length()>0) {
                    sb.setLength(sb.length() - 4); // remove trailing " OR "
                }
                categoryDiscounts.put(parse(product[0]), Collections.singletonList(new LFUCache.Pair<>("", sb.toString())));
            }
        }
    }

    private static String preComputeWithParent3(String s, Map<String, Map<String, List<LFUCache.Pair<String, String>>>> tempMap) {
        if (s ==null || s.equals("None") || !childParentCategory.containsKey(s)) {
            return null;
        }
        if (tempMap.containsKey(s)) return s;
        String parent = childParentCategory.get(s);
        return preComputeWithParent3(parent, tempMap);
    }

    private static String getDiscountedPrice(String[] product) {
        if (product == null || product.length<3) return null;
        List<LFUCache.Pair<String, String>> discounts = categoryDiscounts.get(parse(product[0]));
        return discounts == null ? parse(product[1]) :discounts.get(0).second;
    }
}
