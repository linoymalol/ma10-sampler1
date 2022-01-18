package etl.extarct;

public interface Extract extends Reader, Parser{
    void extract(String path);
}
