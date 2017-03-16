public class NBody{
    public static void main(String[] args){
	double T = Double.parseDouble(args[0]);
	double dt = Double.parseDouble(args[1]);
	String filename = args[2];
	double radius = readRadius(filename);
	Planet[] allPlanets = readPlanets(filename);
    }
    public static double readRadius(String fileName){
	In in = new In(fileName);
	int number = in.readInt();
	double radius = in.readDouble();
	return radius;
    }
    public static Planet[] readPlanets(String fileName){
	Planet[] allPlanets = new Planet[5];
	for (int i = 0; i < 5; i++){
	    allPlanets[i] = new Planet(0.0, 0.0, 0.0, 0.0, 0.0, "");
	} 
	int index = 0;
	In in = new In(fileName);
	int number = in.readInt();
	double radius = in.readDouble();
	while(!in.isEmpty()){
	    if (index/6 < 5){
	    switch(index%6){
	        case 0:
		    allPlanets[index/6].xxPos = in.readDouble();
		    break;
	        case 1:
		    allPlanets[index/6].yyPos = in.readDouble();
		    break;
	        case 2:
		    allPlanets[index/6].xxVel = in.readDouble();
		    break;
	        case 3:
		    allPlanets[index/6].yyVel = in.readDouble();
		    break;
	        case 4:
		    allPlanets[index/6].mass = in.readDouble();
		    break;
	        case 5:
		    allPlanets[index/6].imgFileName = in.readString();
		    break;
	    }
	    }else{
		break;
	    }
	index++;
	}
	System.out.println("end");
      	return allPlanets;
	}
}