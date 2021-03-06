package com.cs7is4_g12.fleschkincaid_1;

import com.cs7is4_g12.fleschkincaid_1.FleschKincaid;
import com.cs7is4_g12.fleschkincaid_1.io.FileReader;
import com.cs7is4_g12.fleschkincaid_1.lexer.sentence.StandfordNLPSentenceLexer;

import org.junit.Test;
 
public class FleschKincaidTest {

    @Test
    public void control() {
        //                                 Expected / Actual
        test("control/cat_in_the_hat.txt");       // 111 / 108
        test("control/cnn_article.txt");          // 52  / 44.9
        test("control/gettysburg_address.txt");   // 66  / 63
        test("control/harry_potter.txt");         // 64  / 59.3
        test("control/state_of_the_union.txt");   // 70  / 57.2
        test("control/voter_preference.txt");     // 28.7/ 26.9

        //                                           Expected / Actual
        testStandford("control/cat_in_the_hat.txt");       // 111 / 118
        testStandford("control/cnn_article.txt");          // 52  / 43
        testStandford("control/gettysburg_address.txt");   // 66  / 63
        testStandford("control/harry_potter.txt");         // 64  / 65
        testStandford("control/state_of_the_union.txt");   // 70  / 59
        testStandford("control/voter_preference.txt");     // 28.7/ 26.9
    }

    @Test
    public void misc() {
        test("childrens_story1.txt");
        test("childrens_story2.txt");
        test("childrens_story3.txt");
        test("lawyer1.txt");
        test("lawyer2.txt");
        test("lawyer3.txt");

        test("sample_textbook.txt");
        test("sample_essay1.txt");
        test("sample_essay2.txt");
        test("sample_essay3.txt");
        test("sample_essay4.txt");

        test("4th_grade_essay1.txt");

        test("kindergarten_essay1.txt");
        test("kindergarten_essay2.txt");
        test("kindergarten_essay3.txt");
    }

    @Test
    public void kenny() {
        test("kennys_essay.txt");
        test("kennys_essay2.txt");
    }

    private void test(final String fileName) {
        final FleschKincaid fleshKincaid = new FleschKincaid();
        final FileReader fileReader = new FileReader();

        System.out.println(fleshKincaid.calculate(fileReader.read(fileName)));
    }

    private void testStandford(final String fileName) {
        final FleschKincaid fleshKincaid = new FleschKincaid();
        fleshKincaid.setSentenceLexer(new StandfordNLPSentenceLexer());
        final FileReader fileReader = new FileReader();

        System.out.println(fleshKincaid.calculate(fileReader.read(fileName)));
    }

}

