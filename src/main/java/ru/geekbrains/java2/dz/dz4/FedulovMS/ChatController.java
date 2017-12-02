package ru.geekbrains.java2.dz.dz4.FedulovMS;
/*
 * Интерфейс контроллера чата.
 */
public interface ChatController {
    // Метод, отправляющий сообщение в чат
    void sendMessage(ChatMessage msg);

    // Метод, читающий следующее полученное сообщение из чата
    ChatMessage getNextMessage();

    // Метод, устанавливающий метод родительской формы,
    // который нужно запустить после получения новых сообщений,
    // чтобы вывести новые сообщения на форму.
    void setUpdateFormCallback(Runnable updateFormCallback);
}
