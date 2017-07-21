package com.multithreadexample.problems;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;


class CollectThreadStatus{
	public volatile boolean firstThread = false;
	public volatile boolean secondThread = false;
	public volatile boolean thirdThread = false;
	
	public CollectThreadStatus(){
		firstThread=true;
		secondThread=false;
		thirdThread=false;
	}
	
	public synchronized boolean isfirstThread() throws InterruptedException{
		while(firstThread==false){
			this.wait();
		}
		return true;
	}
	
	public synchronized boolean isSecondThread() throws InterruptedException{
		while(secondThread==false){
			this.wait();
		}
		return true;
	}
	
	public synchronized boolean isThridThread() throws InterruptedException{
		while(thirdThread==false){
			this.wait();
		}
		return true;
	}

	public synchronized void notifyingFirstThread(){
		this.firstThread=true;
		this.secondThread=false;
		this.thirdThread =false;
		this.notifyAll();
	}
	
	public synchronized void notifyingSecondThread(){
		this.firstThread=false;
		this.secondThread=true;
		this.thirdThread =false;
		this.notifyAll();
	}
	public synchronized void notifyingThirdThread(){
		this.firstThread= false;
		this.secondThread=false;
		this.thirdThread =true;
		this.notifyAll();
	}
	
}



class FirstThread implements Runnable{
	
	private AtomicInteger counter;
	private CollectThreadStatus collectThreadStatus;
	Predicate<AtomicInteger> predicate;
	 public FirstThread(CollectThreadStatus status,AtomicInteger counter,Predicate<AtomicInteger> predicate ){
		 this.collectThreadStatus= status;
		 this.counter =counter;
		 this.predicate = predicate;
		 
	 }
	@Override
	public void run() {
		try {
			while(collectThreadStatus.isfirstThread() && predicate.test(counter)){
				System.out.println(0);	
				collectThreadStatus.notifyingSecondThread();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class SecondThread implements Runnable{
	private AtomicInteger counter;
	private CollectThreadStatus collectThreadStatus;
	private Predicate<AtomicInteger> predicate;
	
	 public SecondThread(CollectThreadStatus status,AtomicInteger counter,Predicate<AtomicInteger> predicate){
		 this.collectThreadStatus= status;
		 this.counter=counter;
		 this.predicate=predicate;
	 }
	@Override
	public void run() {
		try {
			while(collectThreadStatus.isSecondThread() && predicate.test(counter)){
				System.out.println(counter.incrementAndGet());	
				collectThreadStatus.notifyingThirdThread();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ThirdThread implements Runnable{
	private AtomicInteger counter;
	private CollectThreadStatus collectThreadStatus;
	Predicate<AtomicInteger> predicate;
	 public ThirdThread(CollectThreadStatus status, AtomicInteger counter,Predicate<AtomicInteger> predicate){
		 this.collectThreadStatus= status;
		 this.counter =counter;
		 this.predicate = predicate;
	 }
	@Override
	public void run() {
		try {
			while(collectThreadStatus.isThridThread() && predicate.test(counter)){
				System.out.println(counter.incrementAndGet());	
				collectThreadStatus.notifyingFirstThread();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class OrderingMultipleThreads {
	public static void main(String[] args) {
		AtomicInteger counter = new AtomicInteger(0);
		Predicate<AtomicInteger> predicate = (t)-> (t.get()<10);
		CollectThreadStatus status = new CollectThreadStatus();
		Thread test1 = new Thread(new FirstThread(status,counter,predicate));
		Thread test2 = new Thread(new SecondThread(status,counter,predicate));
		Thread test3 = new Thread(new ThirdThread(status,counter,predicate));

		test1.start();
		test2.start();
		test3.start();

	}

}
