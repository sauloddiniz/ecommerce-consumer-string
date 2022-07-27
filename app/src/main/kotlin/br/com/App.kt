package br.com

import br.com.consumer.EmailNewOrderConsumer

class App {
    val emailConsumer: EmailNewOrderConsumer
        get() {
            return EmailNewOrderConsumer();
        };

}

fun main() {
    val app = App();
    app.emailConsumer.createConsumer();
}
