

import java.util.Scanner;


public class Lojtar {
	private Guri stones[];
	private Fusha fusha;
	private String ngjyra;
	public Lojtar(String ngjyra,Fusha board)
	{
		fusha=board;
		stones=new Guri[12];
		this.ngjyra=ngjyra;
		int nr=0;
		if(ngjyra=="RED")
		{
			for(int j=5;j > -1;j--)
			{
				stones[nr]=new Guri(0,nr);
				nr++;
			}
			
			for(int j=1;j<7;j++)
			{
				stones[nr]=new Guri(j,nr);
				nr++;
			}
		}
		else if(ngjyra=="BLACK")
		{
			for(int j=0;j<6;j++)
			{
				stones[nr]=new Guri(7,nr+12);
				nr++;
			}
			for(int j=6;j>0;j--)
			{
				stones[nr]=new Guri(j,nr+12);
				nr++;
			}
		}
	}
	public int leviz(int hapa)
	{
		if(hapa==0)
		{
			System.out.println("Levizja e dyte eshte me 0 hapa, prandaj radha i kalon lojtarit tjeter");
			return -1;
		}
		if(mundetLevizje(hapa))
		{
			int id=getIdLevizje(hapa);
			return leviz(id,rreshtiRi(id,hapa));
		}
		System.out.printf("Ju nuk mund te levizni %d hapa",hapa);
		for(int h=hapa-1;h>0;h--)
		{
			if(mundetLevizje(h))
			{
				
				int id=getIdLevizje(h);
				return leviz(id,rreshtiRi(id,h));
			}
		}
		return -1;
	}
	private boolean mundetLevizje(int hapa)
	{
		for(int i=0;i<12;i++)
		{
			if(mundetTeShkoje(rreshtiRi(stones[i].getId(),hapa)))
				return true;
		}
		return false;
	}
	
	private int getIdLevizje(int hapa)
	{
		int id;
		System.out.printf("Lojtari i "+ ngjyra +",levizni %d hapa.\n",hapa);
		while(true)
		{
				    Scanner sc=new Scanner(System.in);
				    System.out.println("Zgjidhni id e gurit qe doni te levizni:");
			        id=sc.nextInt();
			if(id>11||id<0)
				System.out.println("Duhet te japesh numer nga 0 ne 11!!!");
			else if(!mundetTeShkoje(rreshtiRi(id,hapa)))
						System.out.println("Nuk mund te levizet ai gur!!!");	
			else
				 return id;
		}
	}
	private int rreshtiRi(int id,int hapa)
	{
		int row;
		if(ngjyra=="BLACK")
		row=stones[id%12].getRow()-hapa;
		else
			row=stones[id%12].getRow()+hapa;
		return row;
	}
	
	private boolean mundetTeShkoje(int rreshti)
	{
		if(rreshti<0||rreshti>7)
			return false;
	    else if(fusha.kaVendRreshti(rreshti))
			return false;
		else
			return true;
	}
	private int leviz(int id,int r)
	{
		int i=id;
		if(ngjyra=="BLACK")
			i=id+12;
		fusha.fshi(stones[id].getRow(), i);
		stones[id].setRow(r);
		int col=fusha.gjejVendBosh(r);
		return fusha.shto(r, i, col);
	}
	public int pike()
	{
		int piket=0;
		if(ngjyra=="RED")
			for(int i=0;i<12;i++)
			{
				int row = stones[i].getRow();
				if (row == 7) {
				piket+=5;
				} else if (row == 6) {
				piket+=3;
				} else if (row == 5) {
				piket+=2;
				} else if (row == 4) {
				piket+=1;
				}
			}
		else if(ngjyra=="BLACK")
			for(int i=0;i<12;i++)
			{
				int row = stones[i].getRow();
				if (row == 0) {
				piket+=5;
				} else if (row == 1) {
				piket+=3;
				} else if (row == 2) {
				piket+=2;
				} else if (row == 3) {
				piket+=1;
				}
			}
		return piket;
	}
	private class Guri {
	    private int id;
	    private int row;
	    public Guri(int i,int nr){
	    	id=nr;
	        row=i;
	       }
	    public int getId(){
	        return id;
	    }

	    public void setRow(int i){
	    	row=i;
	    }
	    public int getRow(){
	        return row;
	    }
	   }//end class guri
}
