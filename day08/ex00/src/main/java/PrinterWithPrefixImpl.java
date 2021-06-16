public class PrinterWithPrefixImpl implements Printer{
    private Renderer renderer;
    private String prefix = "";

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setPrefix(String prefix){
        this.prefix = prefix;
    }

    @Override
    public void print(String text) {
        System.out.println(prefix + text);
    }
}
