import java.util.Comparator;
import java.util.PriorityQueue;

class Client {
    private boolean isVip;

    public Client(boolean isVip) {
        this.isVip = isVip;
    }

    public boolean isVip() {
        return isVip;
    }
}

public class Main {
    public static void main(String[] args) {

        Comparator<Client> clientComparator = (c1, c2) -> {
            if (c1.isVip() && !c2.isVip()) {
                return -1; // c1 VIP, c2 не VIP
            } else if (!c1.isVip() && c2.isVip()) {
                return 1;  // c2 VIP, c1 не VIP
            } else {
                return 0;  // оба VIP или оба не VIP
            }
        };


        PriorityQueue<Client> priorityQueue = new PriorityQueue<>(clientComparator);

        // Добавляем клиентов в очередь
        priorityQueue.add(new Client(true));  // VIP
        priorityQueue.add(new Client(false)); // Обычный
        priorityQueue.add(new Client(true));  // VIP
        priorityQueue.add(new Client(false)); // Обычный
        priorityQueue.add(new Client(true));  // VIP
        priorityQueue.add(new Client(false)); // Обычный
        priorityQueue.add(new Client(false)); // Обычный
        priorityQueue.add(new Client(true));  // VIP
        priorityQueue.add(new Client(true));  // VIP
        priorityQueue.add(new Client(false)); // Обычный

        // Обслуживаем клиентов в порядке приоритета
        while (!priorityQueue.isEmpty()) {
            Client client = priorityQueue.poll();
            if (client.isVip()) {
                System.out.println("Обслуживаем VIP-клиента");
            } else {
                System.out.println("Обслуживаем обычного клиента");
            }
        }
    }
}
