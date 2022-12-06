package hands_on_4;

import java.util.ArrayList;

public class DataSet {
	
	private ArrayList<Double> x;//marketing spend
	private ArrayList<Double> y;//profit
	
	
	DataSet(){
		x=new ArrayList<Double>();
		y=new ArrayList<Double>();
		HardCode();
	}
	private void HardCode() {
		
		x.add(165349.2);
		x.add(162597.7);
		x.add(153441.51);
		x.add(144372.41);
		x.add(142107.34);
		x.add(131876.9);
		x.add(134615.46);
		x.add(130298.13);
		x.add(120542.52);
		x.add(123334.88);
		x.add(101913.08);
		x.add(100671.96);
		x.add(93863.75);
		x.add(91992.39);
		x.add(119943.24);
		x.add(114523.61);
		x.add(78013.11);
		x.add(94657.16);
		x.add(91749.16);
		x.add(86419.7);
		x.add(76253.86);
		x.add(78389.47);
		x.add(73994.56);
		x.add(67532.53);
		x.add(77044.01);
		x.add(64664.71);
		x.add(75328.87);
		x.add(72107.6);
		x.add(66051.52);
		x.add(65605.48);
		x.add(61994.48);
		x.add(61136.38);
		x.add(63408.86);
		x.add(55493.95);
		x.add(46426.07);
		x.add(46014.02);
		x.add(28663.76);
		x.add(44069.95);
		x.add(20229.59);
		x.add(38558.51);
		x.add(28754.33);
		x.add(27892.92);
		x.add(23640.93);
		x.add(15505.73);
		x.add(22177.74);
		x.add(1000.23);
		x.add(1315.46);
		x.add(0.0);
		x.add(542.05);
		x.add(0.0);
		
		y.add(192261.83);
		y.add(191792.06);
		y.add(191050.39);
		y.add(182901.99);
		y.add(166187.94);
		y.add(156991.12);
		y.add(156122.51);
		y.add(155752.6);
		y.add(152211.77);
		y.add(149759.96);
		y.add(146121.95);
		y.add(144259.4);
		y.add(141585.52);
		y.add(134307.35);
		y.add(132602.65);
		y.add(129917.04);
		y.add(126992.93);
		y.add(125370.37);
		y.add(124266.9);
		y.add(122776.86);
		y.add(118474.03);
		y.add(111313.02);
		y.add(110352.25);
		y.add(108733.99);
		y.add(108552.04);
		y.add(107404.34);
		y.add(105733.54);
		y.add(105008.31);
		y.add(103282.38);
		y.add(101004.64);
		y.add(99937.59);
		y.add(97483.56);
		y.add(97427.84);
		y.add(96778.92);
		y.add(96712.8);
		y.add(96479.51);
		y.add(90708.19);
		y.add(89949.14);
		y.add(81229.06);
		y.add(81005.76);
		y.add(78239.91);
		y.add(77798.83);
		y.add(71498.49);
		y.add(69758.98);
		y.add(65200.33);
		y.add(64926.08);
		y.add(49490.75);
		y.add(42559.73);
		y.add(35673.41);
		y.add(14681.4);
	

		
	}
	public ArrayList<Double> getX() {
		return x;
	}
	public ArrayList<Double> getY() {
		return y;
	}
	

}
