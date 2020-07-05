package JDK8.函数式编程.Lambda;

@FunctionalInterface
public interface MessageBuilder {
    //定义一个拼接消息的抽象方法，返回拼接信息
    public abstract String builderMessage();
}
