////////////////////////////////////////////////////////////////////////////////////
//
//  C212
//
//  Final Project
//  @Author  Brady Anderson
//  Explain: 
//  	Create a standard complex number that supports basic operations
///////////////////////////////////////////////////////////////////////////////////

public class StandardComplex {
	// part a
	
	// instance variables -> be more specific about purpose of variables aka what are they for?
	private Double realPart;
	private Double imagPart; 
	//  Constructors that accepts 2 arguments -> every function should have a comment
	public StandardComplex(Double real, Double imag) {
		realPart = real;
		imagPart = imag;
	}
	
	public StandardComplex() {
		realPart = 0.0;
		imagPart = 0.0;
	}
	
	// getters and setters -> obvious but comment about description of function would be good keep it simple
	public Double getRealPart() {
		return realPart;
	}
	
	public void setRealPart(Double number) {
		realPart = number;
	}
	
	public Double getImagPart() {
		return imagPart;
	}
	
	public void setImagPart(Double number) {
		imagPart = number;
	}
	
	// part b methods 
	// print the format of a standard complex number -> print standard complex number in string 
	public String toString() {
		return realPart + "+ " + imagPart + "i";
	}
	// get the conjugate of the complex number
	public StandardComplex getConjugate() {
		// create conjugate object
		StandardComplex conjugate = new StandardComplex(getRealPart(),-getImagPart());
		return conjugate;
	}
	// convert to a polar complex number
	public PolarComplex getPolarComplex() {
		// find amplitude
		Double amplitude = Math.sqrt(Math.pow(realPart, 2) + Math.pow(imagPart, 2));
		// find angle
		Double angle = Math.atan(imagPart/realPart);
		// create object w/ values
		PolarComplex standardToPolar = new PolarComplex(amplitude, angle);
		return standardToPolar;
	}
	// get the standard complex form
	public StandardComplex getStandardComplex() {
		// create object w/ parts
		StandardComplex polarToStandard = new StandardComplex(realPart, imagPart);
		return polarToStandard;
	}
	
	// part c methods
	// check if 2 complex numbers are the same
	public boolean isEqual(Object other) {
		if(other instanceof StandardComplex) {
			// cast to the right type of object
			StandardComplex otherObject = (StandardComplex) other;
			// check if equal by using the toString method .equals method
			return toString().equals(otherObject.toString());	
		} else {
			// casting object
			PolarComplex otherObject = (PolarComplex) other;
			// parts of string in standard pieces
			Double real = (otherObject.getAmplitude() * Math.cos(otherObject.getAngle()));
			Double imag = (otherObject.getAmplitude() * Math.sin(otherObject.getAngle()));
			// get aspects and convert to the correct form
			String polarInStandard = real + "+ " + imag + "i";
			// check if equal by using the toString method .equals method
			return toString().equals(polarInStandard);		
		}
	}
	// adds 2 complex numbers
	public StandardComplex add(Object other) {
		Double real;
		Double imag;
		if(other instanceof StandardComplex) {
			StandardComplex otherObject = (StandardComplex) other;
			// subtract real part
			real = realPart + otherObject.getRealPart();
			// subtract imag part
			imag = imagPart + otherObject.getImagPart();
		} else {
			PolarComplex otherObject = (PolarComplex) other;
			// calculate real part
			real = realPart + (otherObject.getAmplitude() * Math.cos(otherObject.getAngle()));
			// calculate imag part
			imag = imagPart + (otherObject.getAmplitude() * Math.sin(otherObject.getAngle()));
		}
		// create new object w/ difference
		StandardComplex addComplex = new StandardComplex(real, imag);
		return addComplex;
	}
	// subtracts 2 complex numbers
	public StandardComplex subtract(Object other) {
		Double real;
		Double imag;
		if(other instanceof StandardComplex) {
			StandardComplex otherObject = (StandardComplex) other;
			// subtract real part
			real = realPart - otherObject.getRealPart();
			// subtract imag part
			imag = imagPart - otherObject.getImagPart();
		} else {
			PolarComplex otherObject = (PolarComplex) other;
			// calculate real part
			real = realPart - (otherObject.getAmplitude() * Math.cos(otherObject.getAngle()));
			// calculate imag part
			imag = imagPart - (otherObject.getAmplitude() * Math.sin(otherObject.getAngle()));
		}
		// create new object w/ difference
		StandardComplex subtractComplex = new StandardComplex(real, imag);
		return subtractComplex;
	}
	// multiplies 2 complex numbers
	public StandardComplex multiply(Object other) {
		// local vars
		Double real;
		Double imag;
		if(other instanceof StandardComplex) {
			StandardComplex otherObject = (StandardComplex) other;
			// mulitply for real part
			real = realPart * otherObject.getRealPart() - imagPart * otherObject.getImagPart();
			// multiply for imag part
			imag = realPart * otherObject.getImagPart() + imagPart * otherObject.getRealPart();
		}
		else {
			PolarComplex otherObject = (PolarComplex) other;
			// calculate real part
			real = realPart * (otherObject.getAmplitude() * Math.cos(otherObject.getAngle()) - imagPart * (otherObject.getAmplitude() * Math.sin(otherObject.getAngle())));
			// calculate imag part
			imag = realPart * (otherObject.getAmplitude() * Math.sin(otherObject.getAngle())) + imagPart * (otherObject.getAmplitude() * Math.cos(otherObject.getAngle()));
		}
		// create new Object w/ values
		StandardComplex multiplyComplex = new StandardComplex(real, imag);
		return multiplyComplex;
	}
	// divides 2 complex numbers
	public StandardComplex divide(Object other) {
		Double real;
		Double imag;
		// parameter is a StandardComplex object
		if(other instanceof StandardComplex) {
			StandardComplex otherObject = (StandardComplex) other;
			// mulitply for real part
			real = (realPart * otherObject.getRealPart() + imagPart * otherObject.getImagPart())/(Math.pow(otherObject.getRealPart(), 2) + Math.pow(otherObject.getImagPart(),2));
			// multiply for imag part
			imag = (realPart * otherObject.getImagPart() + imagPart * otherObject.getRealPart())/(Math.pow(otherObject.getRealPart(), 2) + Math.pow(otherObject.getImagPart(),2));
		}
		// parameter is a PolarComplex object
		else {
			PolarComplex otherObject = (PolarComplex) other;
			// mulitply for real part
			real = (realPart * (otherObject.getAmplitude() * Math.cos(otherObject.getAngle())) + imagPart * (otherObject.getAmplitude() * Math.sin(otherObject.getAngle())))/(Math.pow((otherObject.getAmplitude() * Math.cos(otherObject.getAngle())), 2) + Math.pow((otherObject.getAmplitude() * Math.sin(otherObject.getAngle())),2));
			// multiply for imag part
			imag = (imagPart * (otherObject.getAmplitude() * Math.cos(otherObject.getAngle())) - realPart * (otherObject.getAmplitude() * Math.sin(otherObject.getAngle())))/(Math.pow((otherObject.getAmplitude() * Math.cos(otherObject.getAngle())), 2) + Math.pow((otherObject.getAmplitude() * Math.sin(otherObject.getAngle())),2));
		}
		// create new Object w/ values
		StandardComplex divideComplex = new StandardComplex(real, imag);
		return divideComplex;
	}
	// testing here -> does not include jUnit
	public static void main(String[] args) {
		StandardComplex test = new StandardComplex(2.0, 1.2);
		StandardComplex test1 = new StandardComplex(2.0, 1.2);
		StandardComplex test2 = new StandardComplex(3.0, 4.0);
		System.out.println(test.getConjugate());
		System.out.println(test.getPolarComplex());
		System.out.println(test.getStandardComplex());
		System.out.println(test.isEqual(test1));
		System.out.println(test.isEqual(test2));
		System.out.println(test.add(test1));
		System.out.println(test.add(test2));
		System.out.println(test.subtract(test1));
		System.out.println(test.subtract(test2));
		System.out.println(test.multiply(test1));
		System.out.println(test.multiply(test2));
		System.out.println(test.divide(test1));
		System.out.println(test.divide(test2));
	}

}