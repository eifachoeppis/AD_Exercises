/*
 * Copyright 2020 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw07.bank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class BankAccount {

    private volatile int balance;
    private final Object lock = new Object();

    public BankAccount(final int balance) {
        this.balance = balance;
    }

    public BankAccount() {
        this(0);
    }

    public int getBalance() {
        return this.balance;
    }

    private void deposit(final int amount) {
        synchronized (lock){
            this.balance += amount;
        }
    }

    public void transfer(final BankAccount target, final int amount) {
        synchronized (lock){
            this.balance -= amount;
        }
        Thread.yield();
        target.deposit(amount);
    }
}
