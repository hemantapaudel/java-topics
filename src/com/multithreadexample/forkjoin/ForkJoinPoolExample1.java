package com.multithreadexample.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * 
 * The ForkJoinPool was added to Java in Java 7. The ForkJoinPool is similar to the Java ExecutorService but 
 * with one difference. The ForkJoinPool makes it easy for tasks to split their work up into smaller tasks
 *  which are then submitted to the ForkJoinPool too.
 *   Tasks can keep splitting their work into smaller subtasks for as long as it makes to split up the task. 
 *
 *The fork and join principle consists of two steps which are performed recursively. 
 *These two steps are the fork step and the join step.
 *
 *You submit tasks to a ForkJoinPool similarly to how you submit tasks to an ExecutorService. 
 *You can submit two types of tasks. A task that does not return any result (an "action"), 
 *and a task which does return a result (a "task"). These two types of tasks are represented by 
 *the RecursiveAction and RecursiveTask classes. 
 */
public class ForkJoinPoolExample1 {
	public static void main(String[] args) {
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		MyRecursiveAction myRecursiveAction = new MyRecursiveAction(24);
		forkJoinPool.invoke(myRecursiveAction);
		
		
		MyRecursiveTask myRecursiveTask = new MyRecursiveTask(24);
		long mergedResult = forkJoinPool.invoke(myRecursiveTask);
		System.out.println("mergedResult = " + mergedResult);  
	}
}


class MyRecursiveAction extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long workLoad = 0;
	public MyRecursiveAction(long workLoad) {
		this.workLoad = workLoad;
	}

	@Override
	protected void compute() {

		// if work is above threshold, break tasks up into smaller tasks
		if (this.workLoad > 16) {
			System.out.println("Splitting workLoad : " + this.workLoad);
			
			List<MyRecursiveAction> subtasks = new ArrayList<MyRecursiveAction>();
			subtasks.addAll(createSubtasks());
			for (RecursiveAction subtask : subtasks) {
				subtask.fork();
			}
		} else {
			System.out.println("Doing workLoad myself: " + this.workLoad);
		}
	}

	private List<MyRecursiveAction> createSubtasks() {
		List<MyRecursiveAction> subtasks = new ArrayList<MyRecursiveAction>();

		MyRecursiveAction subtask1 = new MyRecursiveAction(this.workLoad / 2);
		MyRecursiveAction subtask2 = new MyRecursiveAction(this.workLoad / 2);
		subtasks.add(subtask1);
		subtasks.add(subtask2);
		
		return subtasks;
	}
}

 class MyRecursiveTask extends RecursiveTask<Long> {
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long workLoad = 0;

    public MyRecursiveTask(long workLoad) {
        this.workLoad = workLoad;
    }

    protected Long compute() {

        //if work is above threshold, break tasks up into smaller tasks
        if(this.workLoad > 16) {
            System.out.println("Splitting workLoad : " + this.workLoad);
            List<MyRecursiveTask> subtasks =
                new ArrayList<MyRecursiveTask>();
            subtasks.addAll(createSubtasks());

            for(MyRecursiveTask subtask : subtasks){
                subtask.fork();
            }
            long result = 0;
            for(MyRecursiveTask subtask : subtasks) {
                result += subtask.join();
            }
            return result;

        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
            return workLoad * 3;
        }
    }

    private List<MyRecursiveTask> createSubtasks() {
        List<MyRecursiveTask> subtasks =
        new ArrayList<MyRecursiveTask>();

        MyRecursiveTask subtask1 = new MyRecursiveTask(this.workLoad / 2);
        MyRecursiveTask subtask2 = new MyRecursiveTask(this.workLoad / 2);

        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }
}