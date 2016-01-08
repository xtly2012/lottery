package com.chen.lottery.service;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instance;
import weka.core.Instances;
import weka.experiment.InstanceQuery;

public class WekaTest {
	
	private static Instances data = null;
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InstanceQuery query = new InstanceQuery();
		query.setDatabaseURL("jdbc:mysql://localhost:3306/lottery");
		query.setUsername("lottery");
		query.setPassword("111111");
		query.setQuery("select lottery_period_num,lottery_red_first,lottery_red_second,lottery_red_third,lottery_red_fourth,lottery_red_fifth,lottery_red_sixth,lottery_blue_first from lottery_ticket");

//		query.setQuery("select lottery_run_time,lottery_period_num,lottery_red_first,lottery_red_second,lottery_red_third,lottery_red_fourth,lottery_red_fifth,lottery_red_sixth,lottery_blue_first from lottery_ticket");
//		query.setQuery("create table another(a int(2),b varchar(20))");
//		query.setQuery(" insert into another values(1,'aaa')");
		
		Instances insts = query.retrieveInstances();
		
		insts.setClassIndex(insts.numAttributes() - 1);
		
		/*
         * 2.初始化分类器
         * 具体使用哪一种特定的分类器可以选择，请将特定分类器的class名称放入forName函数
         * 这样就构建了一个简单的分类器
         */
		Classifier cfs = (Classifier)Class.forName("weka.classifiers.bayes.NaiveBayes").newInstance();
		
		/*
         * 3.使用训练样本训练分类器
         */
        cfs.buildClassifier(insts);
		
		/*
         * 4.使用测试样本测试分类器的学习效果
         * 在这里我们使用的训练样本和测试样本是同一个，在实际的工作中需要读入一个特定的测试样本
         */
        Instance testInst;

        /*
         * Evaluation: Class for evaluating machine learning models
         * 即它是用于检测分类模型的类
         */
        Evaluation testingEvaluation = new Evaluation(insts);
        int length = insts.numInstances();
        for (int i =0; i < length; i++) {
           testInst = insts.instance(i);
           //通过这个方法来用每个测试样本测试分类器的效果
           testingEvaluation.evaluateModelOnceAndRecordPrediction(cfs, testInst);

        }

       

        /*
         * 5.打印分类结果
         * 在这里我们打印了分类器的正确率
         * 其它的一些信息我们可以通过Evaluation对象的其它方法得到
         */
        System.out.println( "分类器的正确率：" + (1- testingEvaluation.errorRate()));
		
		cfs.buildClassifier(insts);
		System.out.println(query.retrieveInstances());
		setData(query.retrieveInstances());
	}
	
	public static Instances getData() {
		return data;
	}
	
	public static void setData(Instances data) {
		WekaTest.data = data;
	}
	
}
