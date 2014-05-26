/*
 * Copyright 2014 "Masahiko Sakamoto" <sakamoto.gsyc.3s@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package exercise.inject;

import org.glassfish.hk2.api.Factory;

public class SingletonGreetingFactory implements Factory<SingletonGreeting> {

    @Override
    public void dispose(SingletonGreeting greet) {
        System.out.println("SingletonGreetinFactory#dispose() called.");
    }

    @Override
    public SingletonGreeting provide() {
        System.out.println("SingletonGreetinFactory#provide() called.");
        return new SingletonGreeting() {
            @Override
            public String greet(String iam, String you) {
                return "Good Afternoon " + you + ", I'm " + iam + ".";
            }
        };
    }
}
