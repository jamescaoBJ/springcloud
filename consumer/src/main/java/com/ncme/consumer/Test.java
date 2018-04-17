/**
 * Test.java
 * com.ncme.consumer
 * Function： TODO add descript
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年10月24日       lyj
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.ncme.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;




/**
 * ClassName:Test
 * Function: TODO lambda test
 * Reason:	 TODO ADD REASON
 *
 * @author   lyj
 * @version  
 * @since    version 1.0
 * @Date	 2017年10月24日	上午11:34:05
 *
 * @see 	 
 *  
 */

public abstract class Test {
	
	
	
	/**
	 * Creates a new instance of Test.
	 *
	 * @param object
	 */
	
	public abstract void Test1(Object object) ;
	public static void main(String[] args) {
		
		String[] atp = {"Rafael Nadal", "Novak Djokovic",  
			       "Stanislas Wawrinka",  
			       "David Ferrer","Roger Federer",  
			       "Andy Murray","Tomas Berdych",  
			       "Juan Martin Del Potro"};  
			List<String> players =  Arrays.asList(atp);  
			  
		
			  
			
			
			
			players.forEach(player->System.out.println(player));
			
//			players.forEach(System.out::println);
			
			// 使用 lambda 表达式以及函数操作(functional operation)  
			   
			// 在 Java 8 中使用双冒号操作符(double colon operator)  
//			players.forEach(System.out::println);  
			
			
			System.out.println(Test.run(i->i+1));
			
			
	}
	
//	public int run (); =(int x,int y)->{return x + y);

	public static  int run(Function<Integer, Integer> f){
		return f.apply(1);
		
		
	}
	
	
}
