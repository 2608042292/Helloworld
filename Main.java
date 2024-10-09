import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int zombieHealth = scanner.nextInt();

        scanner.close();


        int hits = 0;
        int consecutiveHits = 0;

        while (zombieHealth > 0) {
            hits++;
            zombieHealth -= 2; // 每次砍击减少2点血量


            consecutiveHits++;

            // 检查是否触发了暴击
            if (consecutiveHits == 3) {
                zombieHealth -= 10; // 触发暴击，额外减少10点血量
                consecutiveHits = 0; // 重置连续砍中的次数
            }

        }


        System.out.println(hits);
    }
}