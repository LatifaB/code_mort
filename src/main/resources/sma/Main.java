package resources.sma;

import resources.sma.avatar.MyViewAvatar;
import resources.sma.avatar.SchedulerAvatar;
import resources.sma.particule.MyViewBille;
import resources.sma.particule.SchedulerBille;
import resources.sma.utils.Utils;
import resources.sma.wator.MyViewWator;
import resources.sma.wator.SchedulerWator;

public class Main {

	public static void main(String[] args) {

		SchedulerBille bille = new SchedulerBille();
		MyViewBille viewBille = new MyViewBille();
		bille.addObserver(viewBille);
		bille.run();
		/*
		switch(args[0]) {
			case "bille":
				SchedulerBille bille = new SchedulerBille();
				MyViewBille viewBille = new MyViewBille();
				bille.addObserver(viewBille);
				bille.run();
				break;

			case "wator":
				SchedulerWator wator = new SchedulerWator();
				MyViewWator viewWator = new MyViewWator();
				wator.addObserver(viewWator);
				wator.run();
				break;

			default :
				SchedulerAvatar avatar = new SchedulerAvatar();
				MyViewAvatar viewAvatar = new MyViewAvatar(avatar.getPreys());
				avatar.addObserver(viewAvatar);
				avatar.run();
		}*/

	}

}
