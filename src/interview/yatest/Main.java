package interview.yatest;

import java.util.*;

public class Main {
    private Map<String, String> map;

    public void initializeData(String s) {
        map = new HashMap<>();
        String[] pairs = s.split(";");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            map.put(keyValue[0], keyValue[1]);
        }
    }

    public List<String> query(List<String> keys) {
        List<String> result = new ArrayList<>();
        for (String key : keys) {
            String value = map.get(key);
            if (value == null) {
                result.add("EMPTY");
            } else {
                result.add(value);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int q = scanner.nextInt();
        scanner.nextLine();
        Main main = new Main();
        main.initializeData(s);
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            keys.add(scanner.nextLine());
        }
        List<String> result = main.query(keys);
        for (String value : result) {
            System.out.println(value);
        }
    }
}
