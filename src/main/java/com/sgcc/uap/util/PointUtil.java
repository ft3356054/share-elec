package com.sgcc.uap.util;
import java.text.DecimalFormat;

public class PointUtil {

    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 计算两个经纬度之间的距离
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return km
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        DecimalFormat df = new DecimalFormat("#.000");
        s = Double.parseDouble(df.format(s));

        //返回距离默认为km，如果需要其他单位请记得换算
        return s;
    }
    
    /**
     * 计算两个经纬度之间的距离
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return km
     */
    public static double getDistanceString(String lng01, String lat01, String lng02,  String lat02) {
    	double lat1 = Double.valueOf(lat01);
    	double lng1 = Double.valueOf(lng01);
    	double lat2 = Double.valueOf(lat02);
    	double lng2 = Double.valueOf(lng02);
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        DecimalFormat df = new DecimalFormat("#.000");
        s = Double.parseDouble(df.format(s));

        //返回距离默认为km，如果需要其他单位请记得换算
        return s;
    }
    
    
    /**
     * 获取距离范围
     * By  guoqing
     */
    
    
    private static double PI = Math.PI; //3.14159265;  //π
    private static double EARTH_RADIUS1 = 6378137;    //地球半径
    private static double RAD = Math.PI / 180.0;   //   π/180



        //region 根据坐标，计算指定范围内的最大最小经纬度
    /// <summary>
    /// 根据坐标，计算指定范围内的最大最小经纬度
    /// </summary>
    /// <param name="lng">经度</param>
    /// <param name="lat">纬度</param>
    /// <param name="raidus">范围（米）</param>
    /// <returns>返回最大、最小经纬度minLng, minLat, maxLng, maxLat</returns>
    public static double[] getAround(double lng, double lat, int raidus)
    {
        //The circumference of the earth is 24,901 miles.
        //24,901/360 = 69.17 miles / degree

        Double latitude = lat;
        Double longitude = lng;

        Double degree = (24901 * 1609) / 360.0;   //地球的周长是24901英里
        double raidusMile = raidus;

        //先计算纬度
        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * raidusMile;
        Double minLat = latitude - radiusLat;
        Double maxLat = latitude + radiusLat;

        //计算经度
        Double mpdLng = degree * Math.cos(latitude * (PI / 180));  //纬度的余弦
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * raidusMile;
        Double minLng = longitude - radiusLng;
        Double maxLng = longitude + radiusLng;
        //System.out.println("["+minLat+","+minLng+","+maxLat+","+maxLng+"]");
        //最小经度，最小纬度，最大经度，最大纬度
        return new double[] { minLng, minLat, maxLng, maxLat };
    }
    
    
    
    
    
    public static void main(String[] args) {
    	//北京中心位于东经116.20、北纬39.56
    	//天津 117.2 39.13
    	String lat1 = "39.56";
    	String lng1 = "116.20";
    	String lat2 = "39.13";
    	String lng2 = "117.2";
    	double ss= getDistance(Double.valueOf(lat1), Double.valueOf(lng1), Double.valueOf(lat2), Double.valueOf(lng2));
    	System.out.println(ss+"km");
	}
}
