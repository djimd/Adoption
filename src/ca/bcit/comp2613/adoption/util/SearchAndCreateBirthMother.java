package ca.bcit.comp2613.adoption.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import java.util.ArrayList;

import ca.bcit.comp2613.adoption.model.BirthMother;
import ca.bcit.comp2613.adoption.model.SortRecord;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Collections;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SearchAndCreateBirthMother {

    public static Logger log = Logger.getLogger(SearchAndCreateHelper.class);
    public static PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();

    static {
        PropertyConfigurator.configure(SearchAndCreateHelper.class
                .getResourceAsStream("log4j.properties"));
        try {
            propertiesConfiguration.load(SearchAndCreateHelper.class
                    .getResourceAsStream("adoption.properties"));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    };

    public static String LOREM_IPSUM = "HEATHER TERESA DORIS GLORIA EVELYN JEAN CHERYL MILDRED KATHERINE JOAN ASHLEY JUDITH ROSE"
            + "AMANDA STEPHANIE CAROLYN CHRISTINE MARIE JANET CATHERINE FRANCES ANN JOYCE DIANE ALICE JULIE"
            + "SHANNON SHEILA ETHEL ELLEN ELAINE MARJORIE CARRIE CHARLOTTE MONICA ESTHER PAULINE EMMA JUANITA"
            + "EDNA TIFFANY CARMEN ROSA CINDY GRACE WENDY VICTORIA EDITH KIM SHERRY SYLVIA JOSEPHINE THELMA"
            + "ANITA RHONDA HAZEL AMBER EVA DEBBIE APRIL LESLIE CLARA LUCILLE JAMIE JOANNE ELEANOR VALERIE DANIELLE"
            + "MARILYN ANDREA KATHRYN LOUISE SARA ANNE JACQUELINE WANDA BONNIE JULIA RUBY LOIS TINA PHYLLIS"
            + "JANICE KELLY NICOLE JUDY CHRISTINA KATHY THERESA BEVERLY DENISE TAMMY IRENE JANE LORI RACHEL"
            + "SHIRLEY CYNTHIA ANGELA MELISSA BRENDA AMY ANNA REBECCA VIRGINIA KATHLEEN PAMELA MARTHA DEBRA"
            + "BETTY HELEN SANDRA DONNA CAROL RUTH SHARON MICHELLE LAURA SARAH KIMBERLY DEBORAH JESSICA"
            + "MARY PATRICIA LINDA BARBARA ELIZABETH JENNIFER MARIA SUSAN MARGARET DOROTHY LISA NANCY KAREN";

    public static ArrayList<BirthMother> createBirthMothers() {

        ArrayList<BirthMother> retval = new ArrayList<BirthMother>();
        String[] strs = LOREM_IPSUM.split("\\s");
        Random random = new Random();

        // create loop
        for (int i = 0; i < 102; i++) {   
            int BirthMotherYearsWaiting = 0;
            BirthMother BirthMother = new BirthMother(LOREM_IPSUM, LOREM_IPSUM, LOREM_IPSUM);
            BirthMother.setId(Integer.toString(i+1));
            BirthMother.setFirstName(strs[i].toUpperCase());
            BirthMother.setLastName(new StringBuilder(strs[i]).reverse().toString());
            
            retval.add(BirthMother);
        }
        return retval;
    }

    public static void printBirthMothers(ArrayList<BirthMother> BirthMothers)
            throws IOException {
        log.info(propertiesConfiguration.getString("beginReport"));
        if (propertiesConfiguration.getBoolean("saveReportToFile")) {
            File file = new File("report.txt");
            for (BirthMother BirthMother : BirthMothers) {
                log.info(BirthMother);
                FileUtils.writeLines(file, BirthMothers, true);
            }
        }
    }


    public static void save(List<BirthMother> BirthMothers, BirthMother BirthMother) {
        boolean foundUpdate = false;
        for (BirthMother BirthMotherLoop :BirthMothers) {
            if (BirthMotherLoop.getId().equals(BirthMother.getId())) {
                BirthMotherLoop.setFirstName(BirthMother.getFirstName());
                BirthMotherLoop.setLastName(BirthMother.getLastName());
                foundUpdate = true;
                break;
            }
        }
        if (!foundUpdate) { // do an insert
            BirthMothers.add(BirthMother);
        }
    }

    public static void delete(List<BirthMother> BirthMothers, BirthMother BirthMother) {
        Iterator<BirthMother> iter = BirthMothers.iterator();
        while (iter.hasNext()) {
            BirthMother BirthMotherLoop = iter.next();
            if (BirthMotherLoop.getId().equals(BirthMother.getId())) {
                iter.remove();
                break;
            }
        }
    }
    
    public static void showComparableExample(ArrayList<BirthMother> BirthMothers) {
        ArrayList<SortRecord> myList = new ArrayList<SortRecord>();
        Collections.sort(myList);
        for (SortRecord BirthMother : myList) {
            log.info(BirthMother);
        }
    }

}
