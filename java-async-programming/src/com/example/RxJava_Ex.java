package com.example;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

//-----------------------------------------------------
// Trainer Module
//-----------------------------------------------------

class Trainer {
	public Observable<String> doTeach() {
		Observable<String> stream = Observable.create(e -> {
			Thread thread=Thread.currentThread();
			//
			int i = 1;
			while (i <= 5) {
				TimeUnit.SECONDS.sleep(2);
				String topic = "topic-" + i;
				System.out.println(thread+" - publishing change/event");
				e.onNext(topic);
//				if (new Random().nextBoolean()) {
//					e.onError(new IllegalStateException("nw issue"));
//					break;
//				}
				i++;
			}
			e.onComplete();
		});
		return stream;
	}
}

//-----------------------------------------------------
//Participants Module
//-----------------------------------------------------

class Participant {

	Trainer trainer = new Trainer();

	public void doLearn() {
		Thread thread=Thread.currentThread();
		Observable<String> observableStream = trainer.doTeach();
		observableStream
				.observeOn(Schedulers.computation())
		        .subscribeOn(Schedulers.io())
		        .subscribe(
				next -> System.out.println(thread+ " - Learn " + next),
				error -> System.out.println("Oops " + error), 
				() -> System.out.println("thanks"));

	}
}

public class RxJava_Ex {

	public static void main(String[] args) {

		Participant participant = new Participant();
		participant.doLearn();
		
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
