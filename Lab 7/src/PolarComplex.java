////////////////////////////////////////////////////////////////////////////////////
//
//  C212
//
//  Final Project
//  @Author  Brady Anderson
//  Explain: 
//  	Create a polar complex class that supports basic operations and printing
///////////////////////////////////////////////////////////////////////////////////

public class PolarComplex {
	// part a
	
	// instance variables
	private Double amplitude;
	private Double angle; 
	// overloaded Constructors
	public PolarComplex(Double amp, Double angl) {
		amplitude = amp;
		angle = angl;
	}
	
	public PolarComplex() {
		amplitude = 0.0;
		angle = 0.0;
	}
	// getters and setters
	public Double getAmplitude() {
		return amplitude;
	}
	
	public void setAmplitude(Double number) {
		amplitude = number;
	}
	
	public Double getAngle() {
		return angle;
	}
	
	public void setAngle(Double number) {
		angle = number;
	}
	
	// part b methods 
	// gets the polar form of complex number
	public String toString() {
		// get correct form 
		return getAmplitude() + "( cos"+getAngle()+" + i sin"+getAngle()+")";
	}
	// gets the polar form of a polar number
	public PolarComplex getPolarComplex() {
		// create object w/ parts
		PolarComplex standardToPolar = new PolarComplex(amplitude, angle);
		return standardToPolar;
	}
	// calculates the parts of standard complex number and then creates an object w/ values
	public StandardComplex getStandardComplex() {
		// calculate parts of standard complex
		Double realPart = amplitude * Math.cos(angle);
		Double imagPart = amplitude * Math.sin(angle);
		// create standard complex object
		StandardComplex polarToStandard = new StandardComplex(realPart, imagPart);
		return polarToStandard;
	}
	// get the conjugate of the complex number
	public PolarComplex getConjugate() {
		// create conjugate object -> get the negated angle
		PolarComplex conjugate = new PolarComplex(amplitude,-angle);
		return conjugate;
	}
	// part C
	
	public boolean isEqual(Object other) {
		if(other instanceof StandardComplex) {
			// cast to the right type of object
			StandardComplex otherObject = (StandardComplex) other;
			// check if equal by using the toString method .equals method
			return toString().equals(otherObject.getPolarComplex().toString());	
		} else {
			// casting object
			PolarComplex otherObject = (PolarComplex) other;
			// return if they have same value
			return toString().equals(otherObject.toString());		
		}
	}
	
	public PolarComplex add(Object other) {
		Double real;
		Double imag;
		if(other instanceof StandardComplex) {
			StandardComplex otherObject = (StandardComplex) other;
			Double RealPart = getAmplitude() * Math.cos(getAngle());
			Double ImagPart = getAmplitude() * Math.sin(getAngle());
			real = RealPart + otherObject.getRealPart();
			imag = ImagPart + otherObject.getImagPart();
		} else {
			PolarComplex otherObject = (PolarComplex) other;
			// calculate values
			Double realPart = amplitude * Math.cos(angle);
			Double otherRealPart = otherObject.getAmplitude() * Math.cos(otherObject.getAngle());
			Double imagPart = amplitude * Math.sin(angle);
			Double otherImagPart = otherObject.getAmplitude() * Math.sin(otherObject.getAngle());
			// subtract real part
			real = realPart + otherRealPart;
			// subtract imag part
			imag = imagPart + otherImagPart;
		}
		PolarComplex addComplex = new PolarComplex(real, imag);
		return addComplex;
	}
	
	public PolarComplex subtract(Object other) {
		Double real;
		Double imag;
		if(other instanceof StandardComplex) {
			StandardComplex otherObject = (StandardComplex) other;
			Double RealPart = getAmplitude() * Math.cos(getAngle());
			Double ImagPart = getAmplitude() * Math.sin(getAngle());
			real = RealPart - otherObject.getRealPart();
			imag = ImagPart - otherObject.getImagPart();
		} else {
			PolarComplex otherObject = (PolarComplex) other;
			// calculate values
			Double realPart = amplitude * Math.cos(angle);
			Double otherRealPart = otherObject.getAmplitude() * Math.cos(otherObject.getAngle());
			Double imagPart = amplitude * Math.sin(angle);
			Double otherImagPart = otherObject.getAmplitude() * Math.sin(otherObject.getAngle());
			// subtract real part
			real = realPart - otherRealPart;
			// subtract imag part
			imag = imagPart - otherImagPart;
		}
		// create new object w/ difference
		PolarComplex subtractComplex = new PolarComplex(real, imag);
		return subtractComplex;
	}
	
	public PolarComplex multiply(Object other) {
		Double real;
		Double imag;
		if(other instanceof StandardComplex) {
			StandardComplex otherObject = (StandardComplex) other;
			Double RealPart = getAmplitude() * Math.cos(getAngle());
			Double ImagPart = getAmplitude() * Math.sin(getAngle());
			real = RealPart + otherObject.getRealPart() - ImagPart * otherObject.getImagPart();
			imag = RealPart + otherObject.getImagPart() + ImagPart * otherObject.getRealPart();
		} else {
			PolarComplex otherObject = (PolarComplex) other;
			// calculate values
			Double realPart = amplitude * Math.cos(angle);
			Double otherRealPart = otherObject.getAmplitude() * Math.cos(otherObject.getAngle());
			Double imagPart = amplitude * Math.sin(angle);
			Double otherImagPart = otherObject.getAmplitude() * Math.cos(otherObject.getAngle());
			// mulitply for real part
			real = realPart * otherRealPart - imagPart * otherImagPart;
			// multiply for imag part
			imag = realPart * otherImagPart + imagPart * otherRealPart;
		}
		// create new Object w/ values
		PolarComplex multiplyComplex = new PolarComplex(real, imag);
		return multiplyComplex;
	}
	
	public PolarComplex divide(Object other) {
		Double real;
		Double imag;
		if(other instanceof StandardComplex) {
			StandardComplex otherObject = (StandardComplex) other;
			Double RealPart = getAmplitude() * Math.cos(getAngle());
			Double ImagPart = getAmplitude() * Math.sin(getAngle());
			Double denom = Math.pow(otherObject.getRealPart(), 2) + Math.pow(otherObject.getImagPart(), 2);
			real = (RealPart + otherObject.getRealPart() + ImagPart * otherObject.getImagPart()) / denom;
			imag = (ImagPart * otherObject.getRealPart() - RealPart * otherObject.getImagPart()) / denom;
		} else {
			PolarComplex otherObject = (PolarComplex) other;
			// calculate values
			Double realPart = amplitude * Math.cos(angle);
			Double otherRealPart = otherObject.getAmplitude() * Math.cos(otherObject.getAngle());
			Double imagPart = amplitude * Math.sin(angle);
			Double otherImagPart = otherObject.getAmplitude() * Math.sin(otherObject.getAngle());
			Double denom = Math.pow(otherRealPart, 2) + Math.pow(otherImagPart, 2);
			// mulitply for real part
			real = (realPart * otherRealPart + imagPart * otherImagPart) / denom;
			// multiply for imag part
			imag = (imagPart * otherRealPart - realPart * otherImagPart) / denom;
		}
		// create new Object w/ values
		PolarComplex divideComplex = new PolarComplex(real, imag);
		return divideComplex;
	}
	// testing here -> does not include jUnit
	public static void main(String[] args) {
		PolarComplex test = new PolarComplex(2.0, 1.2);
		PolarComplex test1 = new PolarComplex(2.0, 1.2);
		PolarComplex test2 = new PolarComplex(3.0, .9);
		System.out.println(test.toString());
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
