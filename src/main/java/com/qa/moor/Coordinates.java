package com.qa.moor;

public class Coordinates {

	private int x = 0, y = 0;

	public Coordinates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Coordinates() {
		super();
	}

	public double getDistance() {
		return Math.hypot(x, y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Coordinates [x=" + x + ", y=" + y + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
