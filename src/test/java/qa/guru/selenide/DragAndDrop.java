package qa.guru.selenide;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @Disabled
    @Test
    public void checkDragAndDrop(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $$(".column").first().shouldHave(Condition.text("B"));
        $$(".column").last().shouldHave(Condition.text("A"));
    }

}
