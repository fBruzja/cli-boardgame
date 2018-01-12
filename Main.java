import javax.swing.JOptionPane;
public class Main {

	public static void main(String[] args) {
		Fusha fusha=new Fusha();
		 Lojtar lojtariKuq=new Lojtar("RED",fusha);
		 Lojtar lojtariZi=new Lojtar("BLACK",fusha);
		while(true)
		{
			fusha.afisho();
			int hapa=lojtariKuq.leviz(1);
			fusha.afisho();
			hapa=lojtariKuq.leviz(hapa);
			fusha.afisho();
			if(fusha.mbaroi())
			break;
			hapa=lojtariZi.leviz(1);
			fusha.afisho();
			hapa=lojtariZi.leviz(hapa);
			if(fusha.mbaroi())
			break;
		}
			int red=lojtariKuq.pike();
	        int black=lojtariZi.pike();
	        System.out.println("Lojtari i kuq ka grumbulluar "+red+" pike");
			System.out.println("Lojtari i zi ka grumbulluar"+black+" pike");
	        if(red>black)
				JOptionPane.showMessageDialog(null, "Lojtari i kuq fitoi.");
			else
				JOptionPane.showMessageDialog(null, "Lojtari i zi fitoi.");	
	}//end main
}
