

/**
 * Celestial Body class for NBody
 * @author Edem Ahorlu
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;


	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		// TODO: complete constructor
		this.myXPos = xp;
		this.myYPos = yp;
		this.myXVel = xv;
		this.myYVel = yv;
		this.myMass = mass;
		this.myFileName = filename;
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		// TODO: complete constructor
		this.myXPos = b.myXPos;
		this.myYPos	= b.myYPos;
		this.myXVel = b.myXVel;
		this.myYVel = b.myYVel;
		this.myMass = b.myMass;
		this.myFileName = b.myFileName;


	}

	public double getX() {
		// TODO: complete method
		return myXPos;
	}
	public double getY() {
		// TODO: complete method
		return myYPos;
	}
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}
	
	public double getMass() {
		// TODO: complete method
		return myMass;
	}
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		return Math.sqrt(Math.pow((myXPos-b.myXPos),2) + Math.pow((myYPos-b.myYPos),2));
	}

	public double calcForceExertedBy(CelestialBody b) {
		// TODO: complete method
		double G = 6.67 * Math.pow(10,-11);
		return (G*myMass*b.myMass)/(Math.pow(calcDistance(b),2));
	}

	public double calcForceExertedByX(CelestialBody b) {
		// TODO: complete method
		return (calcForceExertedBy(b)*(b.myXPos-myXPos))/calcDistance(b);
	}
	public double calcForceExertedByY(CelestialBody b) {
		// TODO: complete method
		return (calcForceExertedBy(b)*(b.myYPos-myYPos))/calcDistance(b);
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double sumX = 0;
		for(CelestialBody b:bodies) {
			if (!b.equals(this)) {
				sumX += calcForceExertedByX(b);
			}
		}
		return sumX;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		// TODO: complete method
		double sumY = 0;
		for(CelestialBody b:bodies) {
			if (!b.equals(this)) {
				sumY += calcForceExertedByY(b);
			}
		}
		return sumY;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
		double ax = xforce/myMass;
		double ay = yforce/myMass;
		double nvx = myXVel + deltaT*ax;
		double nx = myXPos + deltaT*nvx;
		double nvy = myYVel + deltaT*ay;
		double ny = myYPos + deltaT*nvy;
		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;
	}

	public void draw(){
		// TODO: complete method
		StdDraw.picture(myXPos,myYPos, "images/"+myFileName);
	}
}
