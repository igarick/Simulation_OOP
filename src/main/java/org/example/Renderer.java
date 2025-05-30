package org.example;

public class Renderer {
//    Рендерер ответственен за визуализацию
//    состояния поля, его отрисовку

    public void renderer(Map map) {
        for (int row = 0; row < 10; row++) {
            String line = "";
            for (int column = 0; column < 5; column++) {
                line += "...";
            }
            System.out.println(line);
        }
    }


}
//public static void main(String[] args) {
//
//}

