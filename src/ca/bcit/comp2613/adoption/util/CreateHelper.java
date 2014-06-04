package ca.bcit.comp2613.adoption.util;

import java.util.ArrayList;

import ca.bcit.comp2613.adoption.model.Adoptee;
import ca.bcit.comp2613.adoption.model.Gender;
import ca.bcit.comp2613.adoption.model.Region;
import ca.bcit.comp2613.adoption.model.TestException;

import java.util.Random;


public class CreateHelper {

	public static String LOREM_IPSUM = 	"MARY	PATRICIA	LINDA	BARBARA	ELIZABETH	JENNIFER	MARIA	SUSAN	MARGARET	DOROTHY	LISA	NANCY	KAREN"
			+ "BETTY	HELEN	SANDRA	DONNA CAROL	RUTH	SHARON	MICHELLE	LAURA	SARAH	KIMBERLY	DEBORAH	JESSICA"
			+ "SHIRLEY	CYNTHIA	ANGELA	MELISSA	BRENDA	AMY	ANNA	REBECCA	VIRGINIA	KATHLEEN	PAMELA	MARTHA	DEBRA"
			+ "AMANDA	STEPHANIE	CAROLYN	CHRISTINE	MARIE	JANET	CATHERINE	FRANCES	ANN	JOYCE	DIANE	ALICE	JULIE"
			+ "HEATHER	TERESA	DORIS	GLORIA	EVELYN	JEAN	CHERYL	MILDRED	KATHERINE	JOAN	ASHLEY	JUDITH	ROSE"
			+ "JANICE	KELLY	NICOLE	JUDY	CHRISTINA	KATHY	THERESA	BEVERLY	DENISE	TAMMY	IRENE	JANE	LORI	RACHEL"
			+ "MARILYN	ANDREA	KATHRYN	LOUISE	SARA	ANNE	JACQUELINE	WANDA	BONNIE	JULIA	RUBY	LOIS	TINA	PHYLLIS"
			+ "NORMA	PAULA	DIANA	ANNIE	LILLIAN	EMILY	ROBIN	PEGGY	CRYSTAL	GLADYS	RITA	DAWN	CONNIE	FLORENCE	TRACY "
			+ "EDNA	TIFFANY	CARMEN	ROSA	CINDY	GRACE	WENDY	VICTORIA	EDITH	KIM	SHERRY	SYLVIA	JOSEPHINE	THELMA"
			+ "SHANNON	SHEILA	ETHEL	ELLEN	ELAINE	MARJORIE	CARRIE	CHARLOTTE	MONICA	ESTHER	PAULINE	EMMA	JUANITA"
			+ "ANITA	RHONDA	HAZEL	AMBER	EVA	DEBBIE	APRIL	LESLIE	CLARA	LUCILLE	JAMIE	JOANNE	ELEANOR	VALERIE	DANIELLE";
			

	public static ArrayList<Adoptee> createAdoptees() {
		ArrayList<Adoptee> retval = new ArrayList<>();
		String[] strs = LOREM_IPSUM.split("\\s");		
		Random random = new Random();

		// create loop
		for (int i = 0; i < 102; i++) {
			Adoptee adoptee = new Adoptee();
			adoptee.setId(Integer.toString(i));
			adoptee.setFirstName(strs[i].toUpperCase());
			adoptee.setLastName(new StringBuilder(strs[i]).reverse().toString());
			adoptee.setGender(Gender.values()[random.nextInt(Gender.values().length)]);
			adoptee.setRegion(Region.values()[random.nextInt(Region.values().length)]);
			retval.add(adoptee);
		}
		return retval;
	}

	public static void printAdoptees(ArrayList<Adoptee> adoptees) {
		for (Adoptee adoptee : adoptees) {
			System.out.println(adoptee);
		}
	}

	public static ArrayList<Adoptee> searchAdopteesByFirstName(ArrayList<Adoptee> adoptees, 
			String firstName) throws TestException {
		ArrayList<Adoptee> retval = new ArrayList<>();
		for (Adoptee adoptee : adoptees) {
			if (adoptee.getFirstName().equals(firstName)) {
				retval.add(adoptee);
			}
		}
		return retval;
	}

	public static ArrayList<Adoptee> searchAdopteesByFirstNameRegex(
			ArrayList<Adoptee> adoptees, String regex) throws TestException {
		ArrayList<Adoptee> retval = new ArrayList<>();
		for (Adoptee adoptee : adoptees) {
			 if (adoptee.getFirstName().matches(regex)) {
				 System.out.println(adoptee);
			 }
		}
		return retval;
	}
}	
	
