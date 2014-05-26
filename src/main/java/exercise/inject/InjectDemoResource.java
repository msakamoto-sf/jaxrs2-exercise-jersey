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

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/ex1/inject-prelookup-demo")
public class InjectDemoResource {

    @Inject
    Greeting greet;

    @Inject
    SingletonGreeting sgreet;

    /**
     * curl -v -X GET http://127.0.0.1:8580/myapp/ex1/inject-prelookup-demo
     * 
     * @param info
     * @return
     */
    @GET
    @Produces("text/plain")
    public String hello() {
        String g1 = greet.greet("Bob");
        String g2 = sgreet.greet("Jon", "Alice");
        return g1 + "\r\n" + g2;
    }
}
