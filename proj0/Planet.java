public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
	xxPos = xP;
	yyPos = yP;
	xxVel = xV;
	yyVel = yV;
	mass = m;
	imgFileName = img;
    }
    public Planet(Planet p){
	xxPos = p.xxPos;
	yyPos = p.yyPos;
	xxVel = p.xxVel;
	yyVel = p.yyVel;
	mass = p.mass;
	imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p){
	return Math.sqrt((p.xxPos-xxPos)*(p.xxPos-xxPos)+(p.yyPos-yyPos)*(p.yyPos-yyPos));
    }
    public double calcForceExertedBy(Planet p){
	double distance = calcDistance(p);
	return 0.0000000000667*mass*p.mass/(distance*distance);
    }
    public double calcForceExertedByX(Planet p){
	double distance = calcDistance(p);
	return calcForceExertedBy(p)*(p.xxPos-xxPos)/distance;
    }
    public double calcForceExertedByY(Planet p){
	double distance = calcDistance(p);
	return calcForceExertedBy(p)*(p.yyPos-yyPos)/distance;
    }
    public double calcNetForceExertedByX(Planet[] allPlanets){
	double forceX = 0.0;
	for(int i = 0; i < allPlanets.length; i++){
	    if (this != allPlanets[i]){
		    forceX += calcForceExertedByX(allPlanets[i]);
	    }
	}
	return forceX;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
	double forceY = 0.0;
	for(int i = 0; i < allPlanets.length; i++){
	    if (this != allPlanets[i]){
		    forceY += calcForceExertedByY(allPlanets[i]);
	    }
	}
	return forceY;
    }
    public void update(double dt, double fX, double fY){
	double xxAcc = fX/mass;
	double yyAcc = fY/mass;
	xxVel += xxAcc*dt;
	yyVel += yyAcc*dt;
	xxPos += xxVel*dt;
	yyPos += yyVel*dt;
    }
}