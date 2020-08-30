package targil_1_and_2;

import java.util.Random;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class Test {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx // the Spring "sandbox" within regular Java. Singleton
				= new AnnotationConfigApplicationContext(SpringConfig.class)) {
			Environment env = ctx.getBean(Environment.class);
//			ex 1.
			Random rand = new Random();
//			int max = env.getRequiredProperty("max_value", Integer.class);
//			int min = env.getRequiredProperty("min_value", Integer.class);
//			int difference = max - min;
//			int secNum = rand.nextInt(difference) + min;
//			System.out.println(secNum);
//			int maxGuesses = env.getRequiredProperty("num_of_tries", Integer.class);
//			Scanner scan = new Scanner(System.in);
//			for (int i = 0; i < maxGuesses; i++) {
//				if (scan.nextInt() == secNum) {
//					System.out.println("correct");
//					break;
//				}
//				System.out.println("try again");
//			}
//			
//			ex 2.
			String redTeamName = env.getRequiredProperty("red_team_name");
			String blueTeamName = env.getRequiredProperty("blue_team_name");
			int redTeamLives = env.getRequiredProperty("red_team_lives", Integer.class);
			int blueTeamLives = env.getRequiredProperty("blue_team_lives", Integer.class);
			Team teamRed = ctx.getBean(Team.class, redTeamName, redTeamLives);
			Team teamBlue = ctx.getBean(Team.class, blueTeamName, blueTeamLives);
			System.out.println(teamRed);
			System.out.println(teamBlue);
			while (teamRed.getLives() > 0 && teamBlue.getLives() > 0) {
				int choice = rand.nextInt(10) + 1; // 1 - 10
				if (choice <= 5) { // red team win
					teamBlue.setLives(teamBlue.getLives()-1);
				}else {
					teamRed.setLives(teamRed.getLives()-1);
				}
				System.out.println("team blue lives: " + teamBlue.getLives());
				System.out.println("team red lives: " + teamRed.getLives());
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			}
			if (teamRed.getLives() == 0) {
				System.out.println("team blue won");
			} else {
				System.out.println("team red won");
			}
		}
	}
}
