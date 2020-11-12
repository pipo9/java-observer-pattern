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
	public static void main(String args[]) 
	{ 
        int x; 
        Scanner myObj = new Scanner(System.in);
		BeingObserved beingObserved = new BeingObserved(); 
        Hexa hexa = new Hexa();
        Dicmal dicmal=new Dicmal();
        Binary binary=new Binary();
     
        //sub to be notified
		beingObserved.subs(hexa); 
		beingObserved.subs(dicmal); 
		beingObserved.subs(binary); 
        System.out.println("enter x value"); 
         x = myObj.nextInt();  
        beingObserved.notifyallsubs(x+1); 
        
        //unsub to not be notified
        beingObserved.unsubs(binary); 
        System.out.println("enter x value"); 
         x = myObj.nextInt();  
        beingObserved.notifyallsubs(x+1); 
		
		
	} 
} 
