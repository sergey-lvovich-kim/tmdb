package com.mikyegresl.themoviedatabase.utils.rx

import io.reactivex.*

abstract class RxSchedulersTransformer {
    abstract val mainThreadScheduler: Scheduler
    abstract val ioScheduler: Scheduler
    abstract val computationScheduler: Scheduler

    fun <T> getIOToMainTransformer(): ObservableTransformer<T, T> {
        return ObservableTransformer { objectObservable ->
            objectObservable
                .subscribeOn(ioScheduler)
                .observeOn(mainThreadScheduler)
        }
    }

    fun <T> getIOToMainTransformerMaybe(): MaybeTransformer<T, T> {
        return MaybeTransformer { objectObservable ->
            objectObservable
                .subscribeOn(ioScheduler)
                .observeOn(mainThreadScheduler)
        }
    }

    fun <T> getIOToMainTransformerSingle(): SingleTransformer<T, T> {
        return SingleTransformer { objectObservable ->
            objectObservable
                .subscribeOn(ioScheduler)
                .observeOn(mainThreadScheduler)
        }
    }

    fun getIOToMainTransformerCompletable(): CompletableTransformer {
        return CompletableTransformer { objectObservable ->
            objectObservable
                .subscribeOn(ioScheduler)
                .observeOn(mainThreadScheduler)
        }
    }

    fun <T> getIOToMainTransformerFlowable(): FlowableTransformer<T, T> {
        return FlowableTransformer { objectObservable ->
            objectObservable
                .subscribeOn(ioScheduler)
                .observeOn(mainThreadScheduler)
        }
    }

    fun <T> getComputationToMainTransformer(): ObservableTransformer<T, T> {
        return ObservableTransformer { objectObservable ->
            objectObservable
                .subscribeOn(computationScheduler)
                .observeOn(mainThreadScheduler)
        }
    }

    fun <T> getComputationToMainTransformerSingle(): SingleTransformer<T, T> {
        return SingleTransformer { objectObservable ->
            objectObservable
                .subscribeOn(computationScheduler)
                .observeOn(mainThreadScheduler)
        }
    }

    fun getComputationToMainTransformerCompletable(): CompletableTransformer {
        return CompletableTransformer { objectObservable ->
            objectObservable
                .subscribeOn(computationScheduler)
                .observeOn(mainThreadScheduler)
        }
    }

    fun <T> getComputationToMainTransformerFlowable(): FlowableTransformer<T, T> {
        return FlowableTransformer { objectObservable ->
            objectObservable
                .subscribeOn(computationScheduler)
                .observeOn(mainThreadScheduler)
        }
    }
}