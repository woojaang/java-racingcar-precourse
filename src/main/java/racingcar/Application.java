package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {

    public Car[] makeCars(String[] names) {
        Car[] cars = new Car[names.length];
        for (int i=0; i< names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }

    public void raceResult(Car[] cars, int numberOfAttempts){
        System.out.println("실행결과");
        for (int i=0; i<numberOfAttempts; i++) {
            for (int j=0; j< cars.length; j++) {
                System.out.println(cars[j].race());
            }
            System.out.println();
        }
    }

    public ArrayList<String> getWinners(Car[] cars) {
        int maxScore = 0;
        ArrayList<String> winners = new ArrayList<String>();
        for (int i=0; i<cars.length; i++) {
            if (cars[i].getPosition() == maxScore) {
                winners.add(cars[i].getName());
            }
            if (cars[i].getPosition() > maxScore) {
                maxScore = cars[i].getPosition();
                winners.clear();
                winners.add(cars[i].getName());
            }
        }
        return winners;
    }

    public void printWinners(ArrayList<String> winners) {
        String result = "최종 우승자 : "+winners.get(0);
        if (winners.size() > 1) {
            for (int i=1; i< winners.size(); i++) {
                result += ", "+winners.get(i);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Application application = new Application();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfAttempts = Integer.parseInt(Console.readLine());
        System.out.println();

        Car[] cars = application.makeCars(names);
        application.raceResult(cars, numberOfAttempts);
        ArrayList<String> winners = application.getWinners(cars);
        application.printWinners(winners);
    }
}
