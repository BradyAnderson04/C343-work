////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
// Exam part 2
//@Author  Brady Anderson
//Explain: 
//			creates a circle relying heavily on oval and shape classes
///////////////////////////////////////////////////////////////////////////////////

public class Circle extends Oval{

	// additional instance variables    
	public Circle(int x, int y,double diameter, int dx, int dy) {
		// is this how I chain constructor?
		 super(x, y, diameter, diameter, dx, dy);
	}

	// formats the output of what an object is
	public String toString() {
		return super.toString();
	}
}
