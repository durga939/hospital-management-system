package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DiseasePredictionServlet")
public class DiseasePredictionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String symptomsInput = request.getParameter("symptoms").toLowerCase();

        // Disease database (Symptom mapping)
        Map<String, String[]> diseaseMap = new HashMap<>();

        diseaseMap.put("Flu", new String[]{"fever","cough","cold","body pain"});
        diseaseMap.put("Common Cold", new String[]{"cold","sneezing","runny nose"});
        diseaseMap.put("Migraine", new String[]{"headache","nausea","light sensitivity"});
        diseaseMap.put("Typhoid", new String[]{"high fever","weakness","stomach pain"});
        diseaseMap.put("Malaria", new String[]{"fever","chills","sweating"});
        diseaseMap.put("Dengue", new String[]{"fever","joint pain","rash"});
        diseaseMap.put("COVID-19", new String[]{"fever","breathing","loss of taste"});
        diseaseMap.put("Diabetes", new String[]{"frequent urination","increased thirst","fatigue"});
        diseaseMap.put("High Blood Pressure", new String[]{"dizziness","blurred vision","headache"});
        diseaseMap.put("Heart Disease", new String[]{"chest pain","shortness of breath"});
        diseaseMap.put("Asthma", new String[]{"wheezing","breathing problem"});
        diseaseMap.put("Gastric Ulcer", new String[]{"stomach pain","burning","acidity"});
        diseaseMap.put("Food Poisoning", new String[]{"vomiting","diarrhea","stomach cramps"});
        diseaseMap.put("Kidney Stones", new String[]{"lower back pain","pain while urinating"});
        diseaseMap.put("Anemia", new String[]{"fatigue","pale skin","weakness"});
        diseaseMap.put("Tuberculosis", new String[]{"cough","weight loss","night sweats"});
        diseaseMap.put("Pneumonia", new String[]{"chest pain","fever","cough"});
        diseaseMap.put("Appendicitis", new String[]{"right lower abdomen pain","vomiting"});
        diseaseMap.put("Depression", new String[]{"sadness","low energy","sleep problems"});
        diseaseMap.put("Thyroid Disorder", new String[]{"weight gain","hair loss","fatigue"});
        diseaseMap.put("Allergy", new String[]{"itching","sneezing","rash"});
        diseaseMap.put("Arthritis", new String[]{"joint pain","stiffness"});
        diseaseMap.put("Sinusitis", new String[]{"headache","facial pain","blocked nose"});
        diseaseMap.put("Chickenpox", new String[]{"rash","fever","itching"});
        diseaseMap.put("Measles", new String[]{"rash","high fever","red eyes"});
        diseaseMap.put("Hepatitis", new String[]{"yellow skin","fatigue","loss of appetite"});
        diseaseMap.put("Ulcerative Colitis", new String[]{"abdominal pain","bloody stool"});
        diseaseMap.put("Pancreatitis", new String[]{"upper abdominal pain","vomiting"});
        diseaseMap.put("Bronchitis", new String[]{"cough","mucus","fatigue"});
        diseaseMap.put("Anxiety Disorder", new String[]{"restlessness","rapid heartbeat"});
        diseaseMap.put("Stroke", new String[]{"face drooping","speech difficulty"});
        diseaseMap.put("Obesity", new String[]{"weight gain","fatigue"});
        diseaseMap.put("Cholera", new String[]{"severe diarrhea","dehydration"});
        diseaseMap.put("Leukemia", new String[]{"frequent infections","bleeding"});
        diseaseMap.put("Psoriasis", new String[]{"skin patches","itching"});
        diseaseMap.put("Parkinson’s Disease", new String[]{"tremor","slow movement"});
        diseaseMap.put("Alzheimer’s Disease", new String[]{"memory loss","confusion"});

        String predictedDisease = "General Checkup Required";
        int maxMatch = 0;

        // Matching algorithm
        for (String disease : diseaseMap.keySet()) {

            int matchCount = 0;
            String[] symptomsList = diseaseMap.get(disease);

            for (String symptom : symptomsList) {
                if (symptomsInput.contains(symptom)) {
                    matchCount++;
                }
            }

            if (matchCount > maxMatch) {
                maxMatch = matchCount;
                predictedDisease = disease;
            }
        }

        // Confidence percentage
        int confidence = maxMatch * 30;
        if(confidence > 100) confidence = 100;

        request.setAttribute("result", predictedDisease);
        request.setAttribute("confidence", confidence + "%");

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}