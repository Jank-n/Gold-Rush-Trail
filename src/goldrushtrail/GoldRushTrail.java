package goldrushtrail;

import java.util.*;
import java.io.*;

public class GoldRushTrail {
	
	

	public static void main(String[] args) {
		//Initialize variables, attributes, arrays to control the game play
		
		//load the saved game if one exists
		GoldRushTrail currentGame = new GoldRushTrail();
		
		
		
		//scanner object
		Scanner scanner = new Scanner(System.in);
		//player object
		Player player = new Player();
		//player attributes set
		player.currentLevel = 0;
		player.currentEnergy = 100;
		player.currentMoney = 10;
		player.currentAmmo = 4;
		player.currentWagonPart = 2;
		player.currentFurs = 0;
		
		
		ArrayList<String> shop = new ArrayList<String>();
		shop.add("Ammo");
		shop.add("Wagon Part");
		shop.add("Furs");
		
		//array list of landmarks
		ArrayList<String> landmark = new ArrayList<String>();
		landmark.add("Fort Garland");
		landmark.add("Pagosa Springs");
		landmark.add("Chimney Rock");
		landmark.add("Halls Crossing");
		landmark.add("Salina");
		landmark.add("Tonopah Pass");
		landmark.add("Olmstead Point");
		landmark.add("Mt. Diablo");
		landmark.add("San Francisco");
				
		File savedGame = new File("savedGame.txt");
		if (savedGame.exists()) {
			System.out.println("Would you like to resume your current game?");
			String resume = scanner.next();
			
			if(resume.equalsIgnoreCase("yes") || resume.equalsIgnoreCase("y")) {
				System.out.println("You last left off at: !");
				
			}//end if
			else if(resume.equalsIgnoreCase("no") || resume.equalsIgnoreCase("n")) {
				System.out.println("Starting new game!\n");
				player.currentEnergy = 100;
				player.currentLevel = 0;
			}//end else if
		}//end if
		
		while (!(player.currentEnergy == 0)){
			
			
					
			
		System.out.println("The Gold Rush trail is calling! Please enter your name before we begin");
		
		
		String name = scanner.next();
		
		System.out.println("\nThank you " + name + "!\n");
		
		
		System.out.println(name + ", you were one of the first homesteaders of San Luis de la Culebra.");
		System.out.println("It is a township within the valley of Sangre de Christo mountain range.");
		System.out.println("You settled in San Luis as the resident hoping to find fortune. Life, however, had other plans.");
		System.out.println("Your homestead... A stray lightning bolt, during a torrential storm, struck it.");
		System.out.println("Your home was set ablaze. You couldn't help but watch it turn to ash.");
		System.out.println("It burned nearly everything you've built except for what is on your person, and in your wagon.\n");
		
		player.printDetails();
		
		System.out.println("After you packed up the wagon, said your goodbyes, you make for the ol' dusty trail to head west seeking a new home, and fortune.\n");
		System.out.println("Your first stop is Fort Garland. It is just north of San Luis. The fortification protects the Sangre de Christo valley. \n");
		
		//First stop will have items for purchase, populate items in array
		//currentGame.itemsForPurchase(New String[]{"Ammo", "Food", "Wagon Parts"});
		//Provide stop details and user input
		if (player.currentLevel == 0) {
			
		
		
		System.out.println("=============================================================================================\n");
		System.out.println("FORT GARLAND\n");
		System.out.println("=============================================================================================");
		System.out.println("You arrive in Fort Garland. It's bustling with travellers, traders, military personnel. What would you like to do?\n");
		System.out.println("\t1. Head to buy supplies and rest"); 
		System.out.println("\t2. Skip resupply and head to the next destination. (-20 energy)");
		System.out.println("\t3. Save and exit the game.");
		
		
		System.out.println("ENTER\n");
		String choice = scanner.next();
	
		
		if (choice.equals("1")) {
			
			player.currentLevel += 1;
			System.out.println("\nYou browse the wares:\n");
			System.out.println(shop);
			while(player.currentMoney >=2) {
			System.out.println("What would you like to buy?");
			System.out.println("\t1. " + shop.get(0) + " - $2");
			System.out.println("\t2. " + shop.get(1) + " - $4");
			System.out.println("\t3. " + shop.get(2) + " - $3");
			System.out.println("\t4. Exit shop");
			System.out.println("ENTER\n");
			String action = scanner.nextLine();
			
			
				
			if(action.equals("1")) {
			player.currentMoney = player.currentMoney-2;
			player.currentAmmo = player.currentAmmo+1;
			System.out.println("You brought 1 " + shop.get(0) + ". ");
			System.out.println("You have $" +player.currentMoney + " left, and " + player.currentAmmo + " ammo.\n");
			}//end if
			if(action.equals("2")) {
				player.currentMoney = player.currentMoney-4;
				player.currentWagonPart = player.currentWagonPart+1;
				System.out.println("You brought 1 " + shop.get(1) + ". ");
				System.out.println("You have $" +player.currentMoney + " left, and " + player.currentWagonPart + " wagon parts.\n");
			}//end if
			if(action.equals("3")) {
				player.currentMoney = player.currentMoney-3;
				player.currentFurs = player.currentFurs+1;
				System.out.println("You brought 1 " + shop.get(2) + ". ");
				System.out.println("You have $" +player.currentMoney + " left, and " + player.currentFurs + " furs.\n");
			}//end if
			if(action.equals("4")) {
				
				System.out.println("You exit the shop.");
				break;
			}//end if
			
			}//end if
		}//end while
		else if (choice.equals("2")) {
			player.currentLevel += 1;
			player.currentEnergy = (player.currentEnergy - 20);
			System.out.println("You proceed with your journey without stopping."+ " You have "+(player.currentEnergy)+" energy remaining.");
		}//end else if
		else if(choice.equals("3")) {
			saveGame(player.currentLevel, player.currentEnergy, player.currentMoney, player.currentAmmo, player.currentWagonPart, player.currentFurs);
			break;
		}//end else if
		}//end level 0
		
	if (player.currentLevel == 1) {
		
	
		System.out.println("=============================================================================================\n");
		System.out.println("PAGOSA SPRINGS\n");
		System.out.println("=============================================================================================");
		System.out.println("You blaze through the trail westward. You are stopped by a native Ute tribe in "+ landmark.get(1)+ ".");
		System.out.println("They let you know you are on sacred land, but they offer you to rest in the hot spring if you trade with them");
		System.out.println("Or they will let you pass without harm.");
		System.out.println("How do you want to proceed?\n");
		System.out.println("\t1. Accept invitation and rest in the hot springs. (+20 energy, -1 furs)");
		System.out.println("\t2. Pass " + landmark.get(1) + " and continue with your journey. (-30 energy)");
		System.out.println("\t3. Save and exit the game.");
		
		System.out.println("ENTER\n");
		String choice = scanner.next();
		
		if (choice.equals("1")) {
			player.currentLevel = player.currentLevel+1;
			player.currentFurs = player.currentFurs-1;
			player.currentEnergy = player.currentEnergy+20;
			System.out.println("You trade a fur to the Ute. They welcome you to rest in the hot spring. You feel your body come back to life"+
			" in the warm embrace of the spring.");
			System.out.println("After your soak and a night's rest, you have " + player.currentEnergy +" energy, and " + player.currentFurs + "furs left.");
		}
		else if(choice.equals("2")) {
			player.currentLevel = player.currentLevel+1;
			player.currentEnergy = player.currentEnergy-30;
			System.out.println("The Ute escort you off their land and let you continue your journey.");
			System.out.println("You have " + player.currentEnergy + " energy remaining.\n");
			
			if(choice.equals("2") && (player.currentEnergy <= 50)) {
				System.out.println("You are starting to become weary from travel. You should rest soon.\n");
			}//end if
		}//end if
		else if(choice.equals("3")) {
			saveGame(player.currentLevel, player.currentEnergy, player.currentMoney, player.currentAmmo, player.currentWagonPart, player.currentFurs);
			break;
		}//end else if
		}//end level if
	
	if (player.currentLevel == 2) {
		
		System.out.println("=============================================================================================\n");
		System.out.println("CHIMNEY ROCK\n");
		System.out.println("=============================================================================================");
		System.out.println("You push through the dry, sparse mountain trail; You take a moment to scan the horizon.");
		System.out.println("You spot a unique rock formation. According to the travellers you overheard in Fort Garland,");
		System.out.println("you know they call this landmark " + landmark.get(2) + ".\n");
		
		System.out.println("The back country can be dangerous, but rest could be nice.");
		System.out.println("How would you like to proceed?\n");
		System.out.println("\t1. Setup camp on " + landmark.get(2) + ", and start fresh tomorrow");
		System.out.println("\t2. Press forward with the journey.");
		System.out.println("\t3. Save and exit game.");
		
		System.out.println("ENTER\n");
		String choice = scanner.next();
		
		if(choice.equals("1")) {
			
			System.out.println("You hitch your wagon, start a campfire, and pitch a tent. You make ready your evening.");
			System.out.println("As you are preparing dinner, you hear a growl in the dark.\n");
			System.out.println("A bear appears! You grab your rifle and aim down your sights!");
			System.out.println("Type 'Shoot' to fire your gun at the bear!\n");
			System.out.println("ENTER\n");
			String action = scanner.nextLine();
			
			if(action.equalsIgnoreCase("shoot")){
				player.currentAmmo = player.currentAmmo-1;
				System.out.println("You take a shot at the bear. You score a good hit, but it's still running towards you!");
				System.out.println("Type 'shoot' to take another shot!");
				System.out.println("ENTER\n");
				action = scanner.next();
				
				if(action.equalsIgnoreCase("shoot")){
					player.currentLevel = player.currentLevel+1;
					player.currentAmmo = player.currentAmmo-1;
					player.currentFurs = player.currentFurs+1;
					player.currentEnergy = player.currentEnergy-10;
					System.out.println("You train your rifle on the bear's head, and you FIRE!");
					System.out.println("The bear goes down. You take moment to let your fear settle.");
					System.out.println("After you collect yourself, you skin the bear for it's fur, and stow it in your wagon.");
					System.out.println("Due to the bear attack, You weren't able to get much rest this night.");
					System.out.println("You have " + player.currentEnergy + " energy remaing, " + player.currentFurs + " fur(s) in the wagon.\n");
					System.out.println("And you have " + player.currentAmmo + " ammo left for your rifle.");
				}//end if
				}//end if
			}//end if
		
		else if (choice.equals("2")) {
			player.currentLevel = player.currentLevel+1;
			player.currentEnergy = player.currentEnergy-20;
			System.out.println("You are feeling eager to press forward on your journey. You bid fairwell to " + landmark.get(2)+ ".\n");
			System.out.println("While on the trail, you hear a...'CRAKCKADFD'. Your wagon abruptly drops, and one of the wheels flies off.");
			System.out.println("You hop off the wagon, gather the wheel, and grab a spare wagon part.");
			System.out.println("'Type' repair to fix the wagon.");
			System.out.println("ENTER\n");
			String action = scanner.next();
			
			if(action.equalsIgnoreCase("repair")) {
				player.currentWagonPart = player.currentWagonPart-1;
				System.out.println("You ratchet the wheel back onto the axel of your wagon.");
				System.out.println("You hop back onto the wagon, and continue towards the next destination.");
				System.out.println("You have " + player.currentWagonPart + " spare wagon part(s) left, and");
				System.out.println("You have "+(player.currentEnergy)+" energy, and + " + player.currentWagonPart + " spare wagon parts remaing.\n");
			
				if((player.currentEnergy <= 50) && action.equalsIgnoreCase("repair")){
				System.out.println("<<<<You are starting to become weary from travel. You should rest soon.>>>>\n");
		
				}//end if
				}//end if
			}//end if 
		else if(choice.equals("3")) {
			saveGame(player.currentLevel, player.currentEnergy, player.currentMoney, player.currentAmmo, player.currentWagonPart, player.currentFurs);
			break;
		}//end else if
		}//end if level 2
	
	if (player.currentLevel == 3) {
		
		System.out.println("=============================================================================================\n");
		System.out.println("HALLS CROSSING\n");
		System.out.println("=============================================================================================");
		System.out.println("Mountain valleys are swept with wild flowers, sage brush, and desiccated trees");
		System.out.println("You drive the wagon downward toward what appears to be a canyon.");
		System.out.println("An outpost marked as " + landmark.get(3) + "lays at the base of a canyon river.");
		System.out.println("The sign also notes there is a ferryman for hire to cross the river.\n");
		
		System.out.println("How would you like to proceed?\n");
		System.out.println("\t1. Pay $2 to the ferryman to cross the canyon river.");
		System.out.println("\t2. Try to cross the river on your own.");
		System.out.println("\t3. Save and exit the game.");
		
		System.out.println("ENTER\n");
		String choice = scanner.next();
		
		if(choice.equals("1")) {
			player.currentLevel = player.currentLevel+1;
			player.currentMoney = player.currentMoney-2;
			player.currentEnergy = player.currentEnergy+10;
			System.out.println("The ferryman commands you to drive the wagon onto the ferry.");
			System.out.println("You give a 'Hayah!' of the reins, and your ox pulls the wagon onto the ferry.");
			System.out.println("The ferryman guides the ferry across the canyon river. You catch some much needed shut-eye in your wagon.");
			System.out.println("You startle awake as the ferryman alerts you that you have made it across.");
			System.out.println("You give another 'HAYAH', and thank the ferryman.\n");
			System.out.println("You have " + player.currentEnergy + " energy remaining, and $" + player.currentMoney + " cash left.");
		}//end if
		else if (choice.equals("2")) {
			player.currentLevel = player.currentLevel+1;
			player.currentEnergy = player.currentEnergy-30;
			player.currentAmmo = player.currentAmmo/2;
			player.currentFurs = player.currentFurs/2;
			player.currentWagonPart = player.currentWagonPart/2;
			
			System.out.println("You decide you would risk driving the ox through the canyon river.");
			System.out.println("Finding a way around the canyon river would take at least another day's worth of travel.");
			System.out.println("The river seems shallow enough for the wagon, but river current likes choppy.");
			System.out.println("You give a big 'HAYAH' with the reins, and your ox pulls the wagon into the water.");
			System.out.println("Your ox makes it halfway through the river, but the aggressive currents push the wagon over.");
			System.out.println("You hang onto the wagon as the ox struggles to push through the water.");
			System.out.println("You see half of your supplies wash away. Your ox manages to pull the wagon onto shore.");
			System.out.println("You wring your clothes out, straighten out the wagon, and check what resources you have left.\n");
			System.out.println("You have " + player.currentEnergy + " energy remaing, " + player.currentAmmo + " ammo left for your rifle,");
			System.out.println(player.currentFurs + " furs, and " + player.currentWagonPart + " spare wagon parts.\n");
			
			if(player.currentEnergy <= 50 && player.currentEnergy >= 1) {
				System.out.println("<<<<You are starting to become weary from travel. You should rest soon.>>>>\n");
			
			if((player.currentEnergy == 0)){
				System.out.println("You collapse from fatigue, and get swept away by the river.\n");
				System.out.println("GAME OVER");
				break;
			}//end if 0 energy
			}//end if 50 energy
		}//end if choice 2
		else if(choice.equals("3")) {
			saveGame(player.currentLevel, player.currentEnergy, player.currentMoney, player.currentAmmo, player.currentWagonPart, player.currentFurs);
			break;
		}//end else if
	}//end level 3
		
	if(player.currentLevel == 4) {
			
		System.out.println("=============================================================================================\n");
		System.out.println("SALINA\n");
		System.out.println("=============================================================================================");
		System.out.println("After a few hours of travel from the " + landmark.get(3) + ", you see a fellow traveller");
		System.out.println("As both your wagons' converge, the traveller tips her hat, and let's you know there is a town ahead");
		System.out.println("You thank her for the information, and let her know there is river crossing from the way you came.");
		System.out.println("You part ways, and you continue the path. You see a sign further on that says, " + landmark.get(4)+ ", 5 miles");
		System.out.println("You make it to " + landmark.get(4) + ". The town is filled with chatter, the clattering of workers doing tasks,");
		System.out.println("and the town crier bellowing the last gossip. The townsfolk give you approving nods as pull through the main street.\n");
		
		System.out.println("How would you like to proceed.\n");
		System.out.println("\t1. Purchase goods, and rest leaving town.");
		System.out.println("\t2. Skip resupply, and continue the journey.");
		System.out.println("\t3. Save and exit the game.\n");
		
		System.out.println("ENTER");
		String choice = scanner.next();
				
		
		if (choice.equals("1")) {
			System.out.println("\nYou head into the General Store to browse for wares:\n");
			System.out.println(shop);
			while(player.currentMoney >=2) {
			System.out.println("What would you like to buy?");
			System.out.println("\t1. " + shop.get(0) + " - $2");
			System.out.println("\t2. " + shop.get(1) + " - $4");
			System.out.println("\t3. " + shop.get(2) + " - $3");
			System.out.println("\t4. Exit shop");
			System.out.println("ENTER\n");
			String action = scanner.next();
							
			if(action.equals("1")) {
			player.currentMoney = player.currentMoney-2;
			player.currentAmmo = player.currentAmmo+1;
			System.out.println("You brought 1 " + shop.get(0) + ". ");
			System.out.println("You have $" +player.currentMoney + " left, and " + player.currentAmmo + " ammo.\n");
			}//end if 1
			if(action.equals("2")) {
				player.currentMoney = player.currentMoney-4;
				player.currentWagonPart = player.currentWagonPart+1;
				System.out.println("You brought 1 " + shop.get(1) + ". ");
				System.out.println("You have $" +player.currentMoney + " left, and " + player.currentWagonPart + " wagon parts.\n");
			}//end if 2
			if(action.equals("3")) {
				player.currentMoney = player.currentMoney-3;
				player.currentFurs = player.currentFurs+1;
				System.out.println("You brought 1 " + shop.get(2) + ". ");
				System.out.println("You have $" +player.currentMoney + " left, and " + player.currentFurs + " furs.\n");
			}//end if 3
			if(action.equals("4")) {
				player.currentLevel = player.currentLevel+1;
				System.out.println("You exit the shop.");
				break;
			}//end if 4
			
			}//end while
		}//end if choice 1
		
		else if (choice.equals("2")) {
			player.currentLevel = player.currentLevel+1;
			player.currentEnergy = (player.currentEnergy - 20);
			System.out.println("You ride through main street, and continue your push westward.");
			System.out.println("You have "+(player.currentEnergy)+" energy remaining.\n");
			
			if((player.currentEnergy <= 50 && (player.currentEnergy >= 1))) {
				System.out.println("<<<<You are starting to become weary from travel. You should rest soon.>>>>\n");
			}
			if((player.currentEnergy == 0)) {
				System.out.println("You collapse unto the ground from the wagon, and break your neck.");
				System.out.println("The townsfolk gather your body, and bury you in the town cemetery in an unmarked grave.\n");
				System.out.println("GAME OVER");
				break;
			}//end else if
		}
		else if(choice.equals("3")) {
			saveGame(player.currentLevel, player.currentEnergy, player.currentMoney, player.currentAmmo, player.currentWagonPart, player.currentFurs);
			break;
		}//end else if
	}//end level 4
	
	if(player.currentLevel == 5) {
		
		System.out.println("=============================================================================================\n");
		System.out.println("TONOPAH PASS\n");
		System.out.println("=============================================================================================");
		System.out.println("You overheard in " + landmark.get(4) + " that the only way through the mountains going west is " + landmark.get(5)+".");
		System.out.println("But you also heard someone got attacked at " + landmark.get(5) + " by a mountain lion.");
		System.out.println("Resting at " + landmark.get(5) + " might be too dangerous. Though, you might need to recover some energy for the night.\n");
		
		System.out.println("How do you want to proceed?");
		System.out.println("\t1. Find a place to camp along the pass.");
		System.out.println("\t2. Trek through the pass");
		System.out.println("\t3. Save and exit the game.");
		
		System.out.println("ENTER\n");
		String choice = scanner.next();
		
		if(choice.equals("1")) {
			player.currentLevel = player.currentLevel+1;
			player.currentEnergy = player.currentEnergy+10;
			System.out.println("You find a dried-up brook nestled by old ruins to hitch your wagon.");
			System.out.println("You get the campfire started, and prepare a hearty stew.");
			System.out.println("You keep your rifle close, while staying alert for any mountain lions.");
			System.out.println("You slightly start to nod to sleep, but then a bush rustles with movement.");
			System.out.println("You startle awake, and see it's a... man. He insists he is not hostile, and has his hands up.");
			System.out.println("His face seems trustworthy enough, so you relex your guard a bit.\n");
			System.out.println("He asks if he can have some stew.\n");
			System.out.println("Type 'y' if you want to give him some stew. Type 'n' if you refuse to give him some stew.");
			
			System.out.println("ENTER\n");
			String action = scanner.next();
		
			if((action.equalsIgnoreCase("y"))) {
				System.out.println("You share a bowl of your hearty stew to the stranger. He wolfs it down as soon as you hand it to him.");
				System.out.println("Once he is finished, he looks up with a smile, and thanks you.");
				System.out.println("He mutters he will won't keep you any longer. He gets up and heads back through the bushes, and wishes you well.");
				System.out.println("You have " + player.currentEnergy + " energy remaining.\n");
			}//end if
			if((action.equalsIgnoreCase("n"))) {
				player.currentAmmo = player.currentAmmo-1;
				System.out.println("He leaps at you with a knife and aims for the juggular.");
				System.out.println("You flick your rifle in his direction.");
				System.out.println("<FIRE> <SMOKE> then <SILENCE>");
				System.out.println("The stranger body falls limp to the ground.");
				System.out.println("You have " + player.currentEnergy + " energy maining, " + player.currentAmmo + " ammo left in your rifle.\n");
			}//end if
			}//end if choice 1
		
		else if (choice.equals("2") && player.currentAmmo >= 1) {
			player.currentEnergy = player.currentEnergy-20;
			System.out.println("You make haste through " + landmark.get(5)+ ", and as your riding hard, you see a mountain lion on your tail.");
			System.out.println("You grab your rifle. You steady your aim. You fire!");
			System.out.println("Type 'shoot' to fire!");
			System.out.println("ENTER\n");
			String action = scanner.next();
				
				if(action.equalsIgnoreCase("shoot")) {
					player.currentLevel = player.currentLevel+1;
					player.currentFurs = player.currentFurs+1;
					player.currentAmmo = player.currentAmmo-1;
					System.out.println("As you're speeding through the mountain pass, you take another shot at the lion.");
					System.out.println("The bullet domes the lion square in the head, and it collapses.");
					System.out.println("You let out a 'WOAH' to rein your ox to a stop, so you get off the wagon.");
					System.out.println("You skin the mountain lion for it's fur, stow in the wagon, and press forward after the commotion\n");
					System.out.println("You have " + player.currentEnergy + " energy maining, " + player.currentAmmo + " ammo left in your rifle, ");
					System.out.println("and " + player.currentFurs + " fur(s) in your wagon.\n");
					
				if(player.currentEnergy <= 50 && player.currentEnergy >= 1) {
						System.out.println("<<<<You are starting to become weary from travel. You should rest soon.>>>>\n");
				
				if((player.currentEnergy <= 0)) {
					System.out.println("You faint while riding. The wagon swings into a rock that shatters the wheel.");
					System.out.println("The wagon flips on top of you and squishes you like a pancake.\n");
					System.out.println("GAME OVER");
				}//end if
				}//end if
				}//end shoot if
			}//end else if
		else if(choice.equals("3")) {
			saveGame(player.currentLevel, player.currentEnergy, player.currentMoney, player.currentAmmo, player.currentWagonPart, player.currentFurs);
			break;
		}//end else if
	}//end level 5
		
		if (player.currentLevel == 6) {
		
			System.out.println("=============================================================================================\n");
			System.out.println("OLMSTEAD POINT\n");
			System.out.println("=============================================================================================");
			System.out.println("The journey has been long, and the vistas have been beautiful. Though, nothing could have prepared you for the Yosemite Valley, or Ahwahnee by the natives.");
			System.out.println("The towering, domed mountainheads. The broad, sweeping cliff faces. The glistening waterfalls. The summit-kissing clouds. The giant groves of sequoias.");
			System.out.println("You have never seen anything like it. You feel close to your final destination.");
			System.out.println("You reach an overlook marked " + landmark.get(6) + ". The view leaves you breathless, but you gather your wits to see the path below.");
			System.out.println("An Ahwahneechee scout approaches you, seemingly, out of thin air. He eyes you up and down then gives a nod of approval.");
			System.out.println("He gestures to you to show your map. He marks a mountain peak called " + landmark.get(7) + ". He suggests it's the last landmark before the bay.");
			System.out.println("You wrap your map to stow it away. You look up to thank the scout, but he vanished. You sigh, take another look at the vistas, and then plot your next move.\n");
			
			System.out.println("How do you want to proceed?");
			System.out.println("\t1. Make camp and prepare to make for Mt. Diablo.");
			System.out.println("\t2. Skip rest and break for Mt. Diablo now.");
			System.out.println("\t3. Save and exit the game.");
			
			System.out.println("ENTER\n");
			String choice = scanner.next();
			
			if(choice.equals("1")) {
				player.currentLevel = player.currentLevel+1;
				player.currentEnergy = player.currentEnergy+20;
				System.out.println("You setup your camp, have a warm dinner, and you get a goodnight's rest");
				System.out.println("You have "+(player.currentEnergy)+" energy remaining.\n");
			}
			else if(choice.equals("2")) {
				player.currentLevel = player.currentLevel+1;
				player.currentEnergy = player.currentEnergy-30;
				System.out.println("You feel too restless to make camp, so you continue the pace to Mt. Diablo.");
				System.out.println("The road was uneventful except for the wagon wheel cracking on a sunken hole on the road.");
				
				System.out.println("Type 'repair' to fix your wagon.");
				System.out.println("ENTER\n");
				String action = scanner.next();
				
				
				if (player.currentEnergy <=0) {
					System.out.println("You pass out due to fatigue as you hit the sunken hole while riding. The wagon diverges off the road, and falls into the Tuolumne River.");
					System.out.println("The wagon drags you to the bottom of the river and you drown.\n");
					System.out.println("GAME OVER");
					break;
				
				}
				
				if (action.equalsIgnoreCase("repair") && player.currentWagonPart == 0) {
					System.out.println("You have no spare parts left. You become stranded in the wilderness.");
					System.out.println("A pack of wolves catch your scent, and find you.\n");
					System.out.println("GAME OVER");
					break;
				}
				if (action.equalsIgnoreCase("repair") && player.currentWagonPart >= 1) {
					player.currentWagonPart = player.currentWagonPart-1;
					System.out.println("You patch the break on the wheel, get back on the wagon, and continue to Mt. Diablo.");
					System.out.println("You have "+(player.currentEnergy)+" energy, and + " + player.currentWagonPart + " spare wagon parts remaing.\n");
					
				if(player.currentEnergy <= 50 && player.currentEnergy >= 1) {
						System.out.println("<<<<You are starting to become weary from travel. You should rest soon.>>>>\n");
				}//end if
				}//end if
			}//end else if
		}//end level 6
		
		if(player.currentLevel == 7) {
			
			System.out.println("=============================================================================================\n");
			System.out.println("MT. DIABLO\n");
			System.out.println("=============================================================================================");
			System.out.println("You crest one of " + landmark.get(7) + "'s foothills. You stop and hop off the wagon. You walk a few paces, and gander.");
			System.out.println("The city of San Francisco is in sight. You fall to your knees, and cry with joy. The coast is not much farther now.");
			System.out.println("You did spot wolf tracks during the trek onto the foothill. You suspect a wolf den could be nearby, but you may need rest to build your energy.\n");
			System.out.println("How do you want to proceed?");
			System.out.println("\t1. Camp overnight before making the final stretch");
			System.out.println("\t2. Skip rest and push yourself to San Francisco.");
			System.out.println("\t3. Save and exit the game.");
			
			System.out.println("ENTER\n");
			String choice = scanner.next();
			
			if(choice.equals("1")) {
				System.out.println("You setup camp, and start preparing dinner. You keep your rifle close.");
				System.out.println("You hear a <<HOWWWWWWWLLL>> in the distance.");
				System.out.println("You throw more wood into the fire then ready your rifle.");
				System.out.println("You see big, yellow eyes looming in the brush.");
				System.out.println("Type 'shoot' to take a shot towards the eyes.");
				System.out.println("ENTER\n");
				String action = scanner.next();
				
				if(action.equalsIgnoreCase("shoot") && player.currentAmmo >= 1) {
					player.currentLevel = player.currentLevel+1;
					player.currentEnergy = player.currentEnergy-10;
					player.currentAmmo = player.currentAmmo-1;
					System.out.println("You fire towards the brush with eyes. You hear a whimper followed by clattering of branches.");
					System.out.println("You assume the wolves have fled, and sit by the fire. Unable to sleep, you munch on some dinner.");
					System.out.println("And you keep your rifle on your person as you wait for dawn.\n");
					System.out.println("You have "+(player.currentEnergy)+" energy remaining.");
					}//end if
					if(player.currentAmmo <=0 || player.currentEnergy <=0) {
						System.out.println("The wolves wait patiently until the campfire burns out.");
						System.out.println("They rush and overwhelm you.\n");
						System.out.println("GAME OVER");
						break;
					}//end if
				}//end if
			else if (choice.equals("2")) {
				player.currentLevel = player.currentLevel+1;
				player.currentEnergy = player.currentEnergy-20;
				System.out.println("You yearn for your journey to come to an end. You cannot convince your body to sleep.");
				System.out.println("You drive down the " + landmark.get(7) +  " foothills, and head straight for " + landmark.get(8) + " bay.");
			if (player.currentEnergy <= 0) {
				System.out.println("As you attempt to make your down, you collapse at the reins.");
				System.out.println("Your ox tramples down the foothills without control, it's leg gets snagged by a giant tree root.");
				System.out.println("The wagon flips and crashes into a tree. The impact launches you, and you shatter your body upon the same tree.\n");
				System.out.println("GAME OVER");
				break;
			}//end if
			}//end else if
			else if(choice.equals("3")) {
				saveGame(player.currentLevel, player.currentEnergy, player.currentMoney, player.currentAmmo, player.currentWagonPart, player.currentFurs);
				break;
			}//end else if
		}//end level 7
			
		if (player.currentLevel == 8) {
			System.out.println("=============================================================================================\n");
			System.out.println("SAN FRANCISCO\n");
			System.out.println("=============================================================================================");
			System.out.println("You have reached San Francisco. It is a city wrought with opportunity thanks to the Gold Rush");
			System.out.println("As you roll in, you feel overhwelmed with joy, hope, and excitement to start your new chapter.");
			System.out.println("It was a long, dangerous journey, but you feel it was all worth it.");
			System.out.println("Congratulations! You have made it.\n");
			System.out.println("=============================================================================================\n");
			System.out.println("THE END\n");
			System.out.println("=============================================================================================");
			break;//end game
		}//end level 8
			//THINGS TO FIX WITHIN THE CODE:
			//TYPOS IN A FEW AREAS
			//FILE SAVE NEEDS TO BE WRITTEN
	
			
		}//end while
		
		}//end main
	
		private static void saveGame(int currentLevel, int currentEnergy, int currrentMoney, int currentAmmo, int currentWagonPart, int currentFurs) {
			
			File savedGame = new File("savedGame.txt");
			
			//if statement to check if save file exists, and to delete if it does
			if (savedGame.exists()) {
				savedGame.delete();
			}//end if
			
			try {
				//create a new writer to write the information to the file
				BufferedWriter writer = new BufferedWriter(new FileWriter("savedGame.txt"));
				
				writer.write("\n Level: " + Integer.toString(currentLevel)+"\n");
				writer.write("\n Energy: " + Integer.toString(currentEnergy)+"\n");
				writer.write("\n Money: " + Integer.toString(currrentMoney)+"\n");
				writer.write("\n Ammo: " + Integer.toString(currentAmmo)+"\n");
				writer.write("\n Wagon Parts: " + Integer.toString(currentWagonPart)+"\n");
				writer.write("\n Furs: " + Integer.toString(currentFurs)+"\n");
				
				writer.close();
				
				System.out.println("---<Game Saved>---");
				
			} catch (IOException e) {
				System.out.println("An error has occured while saving");
				e.printStackTrace();
			}//end try catch
		}//end saveGame method
		
		private static int loadLevel() {
			int currentLevel = 0;
			try {
			
			File savedGame = new File("savedGame.txt");
			if(savedGame.exists()) {
				
				BufferedReader reader = new BufferedReader(new FileReader("savedGame.txt"));
				
				//level line
				currentLevel = Integer.parseInt(reader.readLine());
				//energy line
				reader.readLine();
				//money line
				reader.readLine();
				//ammo line
				reader.readLine();
				//wagon part line
				reader.readLine();
				//furs line
				reader.readLine();
				
				//close reader
				reader.close();
			}
			}catch (IOException e) {
				System.out.println("An error has occured while loading");
				e.printStackTrace();
				currentLevel = 0;
			}//end try catch
			return currentLevel;
		}//end method
		
		private static int loadEnergy() {
			int currentEnergy = 0;
			try {
			
			File savedGame = new File("savedGame.txt");
			if(savedGame.exists()) {
				
				BufferedReader reader = new BufferedReader(new FileReader("savedGame.txt"));
				
				//level line
				reader.readLine();
				//energy line
				currentEnergy = Integer.parseInt(reader.readLine());
				//money line
				reader.readLine();
				//ammo line
				reader.readLine();
				//wagon part line
				reader.readLine();
				//furs line
				reader.readLine();
				
				//close reader
				reader.close();
			}
			}catch (IOException e) {
				System.out.println("An error has occured while loading");
				e.printStackTrace();
				currentEnergy = 0;
			}//end try catch
			return currentEnergy;
		}//end method
		
		private static int loadMoney() {
			int currentMoney = 0;
			try {
			
			File savedGame = new File("savedGame.txt");
			if(savedGame.exists()) {
				
				BufferedReader reader = new BufferedReader(new FileReader("savedGame.txt"));
				
				//level line
				reader.readLine();
				//energy line
				reader.readLine();
				//money line
				currentMoney = Integer.parseInt(reader.readLine());
				//ammo line
				reader.readLine();
				//wagon part line
				reader.readLine();
				//furs line
				reader.readLine();
				
				//close reader
				reader.close();
			}
			}catch (IOException e) {
				System.out.println("An error has occured while loading");
				e.printStackTrace();
				currentMoney = 0;
			}//end try catch
			return currentMoney;
		}//end method
		
		private static int loadAmmo() {
			int currentAmmo = 0;
			try {
			
			File savedGame = new File("savedGame.txt");
			if(savedGame.exists()) {
				
				BufferedReader reader = new BufferedReader(new FileReader("savedGame.txt"));
				
				//level line
				reader.readLine();
				//energy line
				reader.readLine();
				//money line
				reader.readLine();
				//ammo line
				currentAmmo = Integer.parseInt(reader.readLine());
				//wagon part line
				reader.readLine();
				//furs line
				reader.readLine();
				
				//close reader
				reader.close();
			}
			}catch (IOException e) {
				System.out.println("An error has occured while loading");
				e.printStackTrace();
				currentAmmo = 0;
			}//end try catch
			return currentAmmo;
		}//end method
		
		private static int loadWagonPart() {
			int currentWagonPart = 0;
			try {
			
			File savedGame = new File("savedGame.txt");
			if(savedGame.exists()) {
				
				BufferedReader reader = new BufferedReader(new FileReader("savedGame.txt"));
				
				//level line
				reader.readLine();
				//energy line
				reader.readLine();
				//money line
				reader.readLine();
				//ammo line
				reader.readLine();
				//wagon part line
				currentWagonPart = Integer.parseInt(reader.readLine());
				//furs line
				reader.readLine();
				
				//close reader
				reader.close();
			}
			}catch (IOException e) {
				System.out.println("An error has occured while loading");
				e.printStackTrace();
				currentWagonPart = 0;
			}//end try catch
			return currentWagonPart;
		}//end method
		
		private static int loadFurs() {
			int currentFurs = 0;
			try {
			
			File savedGame = new File("savedGame.txt");
			if(savedGame.exists()) {
				
				BufferedReader reader = new BufferedReader(new FileReader("savedGame.txt"));
				
				//level line
				reader.readLine();
				//energy line
				reader.readLine();				
				//money line
				reader.readLine();
				//ammo line
				reader.readLine();
				//wagon part line
				reader.readLine();
				//furs line
				currentFurs = Integer.parseInt(reader.readLine());
				
				//close reader
				reader.close();
			}
			}catch (IOException e) {
				System.out.println("An error has occured while loading");
				e.printStackTrace();
				currentFurs = 0;
			}//end try catch
			return currentFurs;
		}//end method
		

		
	}//end class


