package com.dpc.triangle;

/*输入3个数字，判断是否能够组成一个三角形，
 如果可以，进一步判断是否是等边三角形、等腰三角形、直角三角形、等腰直角三角形或者是一般三角形*/

public class TriangleCheck {

	public final String NOT_TRIANGLE = "不是三角形";
	public final String NORMAL_TRIANGLE = "一般三角形";
	public final String EQUILTERAL_TRIANGLE = "等边三角形";
	public final String ISOSCELES_TRIANGLE = "等腰三角形";
	public final String RIGHT_TRIANGLE = "直角三角形";
	public final String ISOANDRIGHT_TRIANGLE = "等腰直角三角形";

	// 对用户的输入的三条表给一个准确的判断
	public String whichKingTriangle(int fir, int sec, int third) {
		String desc = null;
		// 1.是不是三角形
		if (!isTraingle(fir, sec, third)) {
			desc = NOT_TRIANGLE;
		} else {
			if (isIsosceles(fir, sec, third)) {// 是否是等腰
				if (isEquilteral(fir, sec, third)) {// 是否是等边三角形
					desc = EQUILTERAL_TRIANGLE;
				} else if (isIsoAndRight(fir, sec, third)) {// 是否是直角三角形
					desc = ISOANDRIGHT_TRIANGLE;
				} else {
					desc = ISOSCELES_TRIANGLE;
				}
			} else if (isRight(fir, sec, third)) {// 是直角三角形
				if (isIsoAndRight(fir, sec, third)) {// 是否是等腰直角
					desc = ISOANDRIGHT_TRIANGLE;
				} else {
					desc = RIGHT_TRIANGLE;
				}
			} else {
				desc = NORMAL_TRIANGLE;
			}
		}

		return desc;

	}

	// 根据三条边判定是否能组成一个三角形
	public boolean isTraingle(int first, int second, int third) {
		/* if(a>0 && b>0 && c>0 && a+b>c && a+c>b && b+c>a) */
		return (first > 0 && second > 0 && third > 0 && first + second > third
				&& second + third > first && first + third > second);
	}

	// 是否为等边三角形
	public boolean isEquilteral(int fir, int sec, int third) {
		return (fir == sec && sec == third);
	}

	// 是否为等腰三角形
	public boolean isIsosceles(int fir, int sec, int third) {
		return (fir == sec || fir == third || sec == third);
	}

	// 是否为直角三角形
	public boolean isRight(int fir, int sec, int third) {
		boolean result = false;
		if ((fir * fir + sec * sec) == (third * third))
			result = true;
		if ((fir * fir + third * third) == (sec * sec))
			result = true;
		if ((sec * sec + third * third) == (fir * fir))
			result = true;

		return result;
	}

	// 是否为等腰直角三角形
	public boolean isIsoAndRight(int fir, int sec, int third) {
		boolean result = false;
		if (fir == sec || fir == third || sec == third) {
			if ((fir * fir + sec * sec) == (third * third))
				result = true;
			if ((fir * fir + third * third) == (sec * sec))
				result = true;
			if ((sec * sec + third * third) == (fir * fir))
				result = true;
		}

		return result;
	}

}
