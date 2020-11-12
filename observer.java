import java.util.*; 

class Hexa implements Observer 
{ 
	public void update(Observable obj, Object arg) 
	{ 
         Integer x=(int)arg;
        System.out.println(Integer.toHexString(x));
	} 
} 

class Binary implements Observer 
{ 
	public void update(Observable obj, Object arg) 
	{ 
        Integer x=(int)arg;
        System.out.println(Integer.toBinaryString(x));
	} 
} 
class Dicmal implements Observer 
{ 
	public void update(Observable obj, Object arg) 
	{ 
        System.out.println(arg); 

	} 
} 

class BeingObserved extends Observable 
{ 
	void notifyallsubs( Integer x) 
	{ 
		setChanged(); 
		notifyObservers(x); 
    } 
    
    void subs(Observer o){
        this.addObserver(o);
    }
    void unsubs(Observer o){
        this.deleteObserver(o);
    }

} 

class ObserverDemo { 
    static int x=0; 
	public static void main(String args[]) 
	{ 
		BeingObserved beingObserved = new BeingObserved(); 
        Hexa hexa = new Hexa();
        Dicmal dicmal=new Dicmal();
        Binary binary=new Binary();
        Timer timer=new Timer();
         
        //sub to be notified
		beingObserved.subs(hexa); 
		beingObserved.subs(dicmal); 
        beingObserved.subs(binary); 
        timer.schedule(
            new TimerTask(){ 
                @Override
            public void run() {
                 x=(x+1)%60;
                 beingObserved.notifyallsubs(x); 
            }}
        , 0
        ,1000
        );
        

        
		
		
	} 
} 

