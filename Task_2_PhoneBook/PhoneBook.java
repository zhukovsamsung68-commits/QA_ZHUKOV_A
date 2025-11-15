import java.util.*;

public class PhoneBook {

    private Map<String, List<String>> map = new HashMap<>();
    private Random random = new Random();

    private String generatePhone() {
        StringBuilder sb = new StringBuilder("+7900");
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public void add(String fullName) {
        map.computeIfAbsent(fullName, k -> new ArrayList<>())
                .add(generatePhone());
    }

    public List<String> get(String fullName) {
        return map.getOrDefault(fullName, Collections.emptyList());
    }
}
