
public class Fusha {
	private int redStones[];
	private int blackStones[];
	private int m[][];
	public Fusha()
	{
		redStones=new int[8];
		blackStones=new int[8];
		for(int i=1;i<7;i++)
		{
			redStones[i]=1;
			blackStones[i]=1;
		}
		redStones[0]=6;
		blackStones[0]=0;
		redStones[7]=0;
		blackStones[7]=6;
		m=new int[8][];
		for(int i=1;i<7;i++)
			m[i] = new int[6];
		m[0]=new int[7];
		m[7]=new int[7];
		for(int i=1;i<7;i++)
			for(int j=1;j<5;j++)
				m[i][j]=-1;
		int nr=0;
		for(int j=5;j>=0;j--) 
		{m[0][j]=nr;nr++;}
		for(int j=1;j<7;j++)
		{m[j][0]=nr;nr++;}
		
		
		for(int j=0;j<6;j++) 
		{
			m[7][j]=nr;
			nr++;
		}
		for(int j=6;j>0;j--)
		{
			m[j][5]=nr;
			nr++;
		}
		
	}
	public void afisho()
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<6;j++)
			{
				if(m[i][j]==-1)
					System.out.printf("%10s","EMPTY |");
				else if(m[i][j]<12)
				System.out.printf("%3d%7s",m[i][j],"RED |");
				else
					System.out.printf("%3d%7s",m[i][j]-12,"BLACK|");
			}
			System.out.println();
			for(int j=0;j<15;j++)
				System.out.print("----");
			System.out.println();
		}
		
	}
	public boolean kaVendRreshti(int r)
	{
		if(r==0)
			return false;
		if(r==7)
			return false;
		if(6>redStones[r]+blackStones[r])
			return false;
		return true;
	}
	public int gjejVendBosh(int rreshti)
	{
		if(rreshti==7||rreshti==0)
			return 6;
		for(int i=0;i<6;i++)
			if(m[rreshti][i]==-1)
				return i;
		return -1;
	}

	public int shto(int r, int id,int k)
	{
			
			if(id<12)
				redStones[r]++;
			else
				blackStones[r]++;
			m[r][k]=id;
			if(r!=0&&r!=7)
			    return redStones[r]+blackStones[r]-1;
			else
				return 1;
	} 
	public void fshi(int r,int id)
	{
		
		if(id<12)
			redStones[r]--;
		else
			blackStones[r]--;
		for(int i=0;i<6;i++)
			if(m[r][i]==id)
				m[r][i]=-1;
	}
	
	public boolean mbaroi()
	{
		if(redStones[7]==12||blackStones[0]==12)
			return true;
		int red=-2;
		for(int i=0;i<7;i++)
			if(redStones[i]!=0)
			{
				red=i;
				break;
			}
		int black=10;
		for(int i=7;i>0;i--)
			if(blackStones[i]!=0)
			{
				black=i;
				break;
			}
		if(red>black)
			return true;
		return false;
	}
	
	
	
}//end class Fusha

