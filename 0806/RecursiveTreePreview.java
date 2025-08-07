import java.util.*;

public class RecursiveTreePreview {
    public static void main(String[] args) {
        // 模擬資料夾結構 (用 Map<String, List<String>> 表示，key是資料夾，value是裡面檔案或子資料夾)
        Map<String, List<String>> fileSystem = new HashMap<>();
        fileSystem.put("root", Arrays.asList("file1.txt", "folderA", "folderB"));
        fileSystem.put("folderA", Arrays.asList("file2.txt", "file3.txt", "folderC"));
        fileSystem.put("folderB", Arrays.asList("file4.txt"));
        fileSystem.put("folderC", Arrays.asList("file5.txt"));

        System.out.println("總檔案數: " + countFiles(fileSystem, "root"));

        System.out.println("多層選單結構列印:");
        Map<String, List<String>> menu = new HashMap<>();
        menu.put("主選單", Arrays.asList("檔案", "編輯", "檢視"));
        menu.put("檔案", Arrays.asList("新建", "打開", "保存"));
        menu.put("編輯", Arrays.asList("剪下", "複製", "貼上"));
        menu.put("檢視", Arrays.asList("放大", "縮小"));
        printMenu(menu, "主選單", 0);

        int[][] nestedArray = {{1, 2}, {3, 4, 5}, {6}};
        System.out.println("展平巢狀陣列: " + Arrays.toString(flatten(nestedArray)));

        List<Object> nestedList = Arrays.asList(1, Arrays.asList(2, 3), Arrays.asList(Arrays.asList(4), 5));
        System.out.println("巢狀清單最大深度: " + maxDepth(nestedList));
    }

    // 遞迴計算檔案數（假設資料夾內檔案以 .txt 結尾）
    public static int countFiles(Map<String, List<String>> fs, String folder) {
        int count = 0;
        List<String> contents = fs.get(folder);
        if (contents == null) return 0;
        for (String item : contents) {
            if (item.endsWith(".txt")) count++;
            else count += countFiles(fs, item);
        }
        return count;
    }

    // 遞迴列印多層選單
    public static void printMenu(Map<String, List<String>> menu, String current, int level) {
        printIndent(level);
        System.out.println(current);
        List<String> submenus = menu.get(current);
        if (submenus != null) {
            for (String submenu : submenus) {
                printMenu(menu, submenu, level + 1);
            }
        }
    }

    private static void printIndent(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
    }

    // 遞迴展平巢狀陣列
    public static int[] flatten(int[][] nested) {
        List<Integer> flatList = new ArrayList<>();
        for (int[] arr : nested) {
            for (int val : arr) {
                flatList.add(val);
            }
        }
        return flatList.stream().mapToInt(i -> i).toArray();
    }

    // 遞迴計算巢狀清單最大深度
    public static int maxDepth(Object obj) {
        if (!(obj instanceof List)) return 1;
        List<?> list = (List<?>) obj;
        int max = 1;
        for (Object item : list) {
            int depth = 1 + maxDepth(item);
            if (depth > max) max = depth;
        }
        return max;
    }
}
