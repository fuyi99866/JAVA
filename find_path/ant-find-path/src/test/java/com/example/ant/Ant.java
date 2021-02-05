package com.example.ant;

import java.util.Random;
import java.util.Vector;

public class Ant implements Cloneable {
    private Vector<Integer> tabu;//禁忌表
    private Vector<Integer> allowedCities;//允许搜索的城市
    private float[][] delta;//信息变化矩阵
    private int[][] distance;//距离变化矩阵

    private float alpha;
    private float beta;

    private int tourLength;//路径长度
    private int cityNum;//城市数量

    private int firstCity;//起始城市
    private int currentCity;//当前城市

    public Ant(){
        cityNum = 30;
        tourLength = 0;
    }

    /**
     * 根据蚂蚁数量，构造函数
     * @param num
     */
    public Ant(int num){
        cityNum = num;
        tourLength = 0;
    }

    /**
     * 初始化蚂蚁，随机选择起点城市
     * @param distance 距离矩阵
     * @param a
     * @param b
     */
    public void init(int[][] distance,float a,float b){
        alpha = a;
        beta = b;
        allowedCities = new Vector<Integer>();
        tabu = new Vector<Integer>();
        this.distance = distance;
        delta = new float[cityNum][cityNum];
        for (int i = 0;i<cityNum;i++){
            Integer integer = new Integer(i);
            allowedCities.add(integer);
            for (int j =0 ;j<cityNum;j++){
                delta[i][j] = 0.f;//初始值是float类型，值为0.0
            }
        }

        Random random = new Random(System.currentTimeMillis());
        firstCity = random.nextInt(cityNum);//随机选择一个城市
        for(Integer i:allowedCities){//起点城市不允许搜索
            if (i.intValue() == firstCity){
                allowedCities.remove(i);
                break;
            }
        }

        tabu.add(Integer.valueOf(firstCity));//起点城市加入禁忌表
        currentCity = firstCity;
    }

    /**
     * 选择下一个城市
     * @param pheromone 信息矩阵
     */
    public void selectNextCity(float[][] pheromone){
        float[] p = new float[cityNum];
        float sum = 0.0f;
        //计算分母部分
        for (Integer i :allowedCities) {
            sum += Math.pow(pheromone[currentCity][i.intValue()], alpha)*Math.pow(1.0/distance[currentCity][i.intValue()], beta);
        }
        //计算概率矩阵
        for (int i = 0; i <cityNum ; i++) {
            boolean flag = false;
            for (Integer j:allowedCities){
                if (i == j.intValue()){
                    p[i] = (float) (Math.pow(pheromone[currentCity][i], alpha)*Math.pow(1.0/distance[currentCity][i], beta))/sum;
                    flag = true;
                    break;
                }
            }
            if (flag == false){
                p[i] = 0.f;
            }
        }

        //轮盘赌博选择下一个城市
        Random random = new Random(System.currentTimeMillis());
        float selectP = random.nextFloat();//随机选择下一个城市
        int selectCity = 0;
        float sum1 = 0.f;
        for (int i = 0; i <cityNum ; i++) {
            sum1 += p[i];
            if (sum1>=selectP){
                selectCity = i;
                break;
            }
        }

        //从允许选择的城市中去除已经选择的城市
        for (Integer i:allowedCities) {
            if(i.intValue()==selectCity){
                allowedCities.remove(i);
                break;
            }
        }

        //禁忌表中添加已选的城市
        tabu.add(Integer.valueOf(selectCity));

        //已选择的城市现在是当前城市
        currentCity = selectCity;
    }

    private  int calculateTourLength(){
        int len = 0;
        for (int i = 0; i <cityNum ; i++) {
            len += distance[this.tabu.get(i).intValue()][this.tabu.get(i+1).intValue()];
        }
        return len;
    }

    public Vector<Integer> getAllowedCities(){
        return allowedCities;
    }

    public void setAllowedCities(Vector<Integer> allowedCities) {
        this.allowedCities = allowedCities;
    }

    public int getTourLength() {
        return tourLength;
    }

    public void setTourLength(int tourLength) {
        this.tourLength = tourLength;
    }

    public int getCityNum() {
        return cityNum;
    }

    public void setCityNum(int cityNum) {
        this.cityNum = cityNum;
    }

    public Vector<Integer> getTabu() {
        return tabu;
    }

    public void setTabu(Vector<Integer> tabu) {
        this.tabu = tabu;
    }

    public float[][] getDelta() {
        return delta;
    }

    public void setDelta(float[][] delta) {
        this.delta = delta;
    }

    public int getFirstCity() {
        return firstCity;
    }

    public void setFirstCity(int firstCity) {
        this.firstCity = firstCity;
    }
}
