import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        // | 0 1 2 |
        // | 3 4 5 |
        // | 6 7 8 |
        Scanner sc = new Scanner(System.in);
        char[] arr = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8' };
        char res = 'c'; // c:continue d:draw x:x wins o:o wins
        char player = 'x'; // player 'x' & 'o'
        int pos = 0; // arr[pos]
        while (res != 'x' && res != 'o' && res != 'd') {
            System.out.println("| " + arr[0] + " | " + arr[1] + " | " + arr[2] + " |");
            System.out.println("| " + arr[3] + " | " + arr[4] + " | " + arr[5] + " |");
            System.out.println("| " + arr[6] + " | " + arr[7] + " | " + arr[8] + " |");
            System.out.println("Player: " + player + " Move");
            pos = sc.nextInt();
            if (arr[pos] == 'x' || arr[pos] == 'o') {
                System.out.println("Enter different slot");
                System.out.println("--------------------");
            } else {
                if (player == 'x') {
                    arr[pos] = 'x';
                    player = 'o';
                } else if (player == 'o') {
                    arr[pos] = 'o';
                    player = 'x';
                }
            }

            res = check(arr);
        }
        if (res == 'x') {
            System.out.println("Winner is Player: x");
        } else if (res == 'o') {
            System.out.println("Winner is Player: o");
        } else if (res == 'd') {
            System.out.println("game draw");
        }
    }

    static char check(char[] arr) {
        boolean isCom = isCompleted(arr);
        char winner = checkWinner(arr);
        if (winner == 'x') {
            return 'x';
        } else if (winner == 'o') {
            return 'o';
        } else if (isCom == true && winner == 'x') {
            return 'x';
        } else if (isCom == true && winner == 'o') {
            return 'o';
        } else if (isCom == true) {
            return 'd';
        } else
            return 'c';

    }

    static char checkWinner(char[] arr) {
        // | 0 1 2 |
        // | 3 4 5 |
        // | 6 7 8 |
        if (arr[0] == arr[1] && arr[0] == arr[2])
            return arr[0];
        else if (arr[3] == arr[4] && arr[3] == arr[5])
            return arr[3];
        else if (arr[6] == arr[7] && arr[6] == arr[8])
            return arr[6];
        else if (arr[0] == arr[3] && arr[0] == arr[6])
            return arr[0];
        else if (arr[1] == arr[4] && arr[1] == arr[7])
            return arr[1];
        else if (arr[2] == arr[5] && arr[2] == arr[8])
            return arr[2];
        else if (arr[0] == arr[4] && arr[0] == arr[8])
            return arr[0];
        else if (arr[2] == arr[4] && arr[2] == arr[6])
            return arr[2];
        else
            return 'c';
    }

    static boolean isCompleted(char[] arr) {
        int flag = 0;
        for (int i = 0; i < 9; i++) {
            if (arr[i] == 'x' || arr[i] == 'o') {
                flag = 1;
            } else {
                flag = 0;
                break;
            }

        }
        if (flag == 1) {
            return true;
        } else
            return false;
    }
}