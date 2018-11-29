package cn.mnu.demo.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Streams {
	private enum Status {
		OPEN, CLOSED
	};

	private static final class Task {
		private final Status status;
		private final Integer points;

		Task(final Status status, final Integer points) {
			this.status = status;
			this.points = points;
		}

		public Integer getPoints() {
			return points;
		}

		public Status getStatus() {
			return status;
		}

		@Override
		public String toString() {
			return String.format("[%s, %d]", status, points);
		}
	}
	
	public static void main(String[] args) {
	/*	Stream stream=Stream.generate(new TaskSupplier()).limit(10000000).;
		final Collection< Task > tasks = Arrays.asList(
			    new Task( Status.OPEN, 5 ),
			    new Task( Status.OPEN, 13 ),
			    new Task( Status.CLOSED, 8 ) 
			);
		
//		System.out.println(new Date());
		// Calculate total points of all active tasks using sum()
		final long totalPointsOfOpenTasks = tasks
		    .stream()
		    .filter( task -> task.getStatus() == Status.OPEN )
//		    .filter( task -> task.getStatus() == Status.OPEN )
		    .mapToInt( Task::getPoints )
		    .sum();*/
		Streams streams=new Streams();
		streams.name();
		
	}
	
	private class TaskSupplier implements Supplier<Task>{
		private Random random=new Random();
		@Override
		public Task get() {
			return new Task(random.nextInt()%2==0?Status.OPEN:Status.CLOSED, random.nextInt(100));
		}
		
	}
	public void name() {
		
		Date date1 = new Date();   
		final long totalPointsOfOpenTasks1=Stream.generate(new TaskSupplier()).limit(100000000).parallel().filter(task -> task.getStatus() == Status.OPEN ).mapToInt(Task::getPoints).sum();
		Date now1 =new Date();
		long x1 = now1.getTime()-date1.getTime();
		System.out.println(x1); 
//		System.out.println("Total points1: " + totalPointsOfOpenTasks1);
		
		Date date = new Date();     
		final long totalPointsOfOpenTasks =Stream.generate(new TaskSupplier()).limit(100000000).filter( task -> task.getStatus() == Status.OPEN).mapToInt(Task::getPoints).sum();
		Date now =new Date();
		long x = now.getTime()-date.getTime();
		System.out.println(x);       
//		System.out.println( "Total points: " + totalPointsOfOpenTasks );
		
		System.out.println(x1-x);
	}
} 
