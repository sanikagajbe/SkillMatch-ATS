async function analyzeResumes() {
    // 1. Grab data from the UI
    const jobSkillsRaw = document.getElementById('jobSkills').value;
    const name1 = document.getElementById('name1').value || "Candidate 1";
    const resume1 = document.getElementById('resume1').value;
    const name2 = document.getElementById('name2').value || "Candidate 2";
    const resume2 = document.getElementById('resume2').value;

    // Convert comma-separated string into an array: ["java", "spring", "sql"]
    const jobSkillsList = jobSkillsRaw.split(',').map(skill => skill.trim());

    // 2. Build the JSON Payload matching our Java CandidateRequest model
    const payload = {
        jobSkills: jobSkillsList,
        candidates: [
            { id: name1, resumeText: resume1 },
            { id: name2, resumeText: resume2 }
        ]
    };

    try {
        // 3. Send data to our Spring Boot backend
        const response = await fetch('/api/v1/analyze', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(payload)
        });

        const results = await response.json();

        // 4. Display the results
        displayResults(results);

    } catch (error) {
        console.error("Error communicating with backend:", error);
        alert("Something went wrong! Is your Spring Boot server running?");
    }
}

function displayResults(results) {
    const container = document.getElementById('resultsContainer');
    container.innerHTML = ''; // Clear old results

    results.forEach((result, index) => {
        // Determine color based on suitability
        let colorClass = '';
        if (result.suitability === 'Weak') colorClass = 'weak';
        if (result.suitability === 'Moderate') colorClass = 'moderate';

        // Create a visual card for each candidate
        const card = document.createElement('div');
        card.className = `result-card ${colorClass}`;

        card.innerHTML = `
            <h3>Rank #${index + 1}: ${result.id}</h3>
            <p><strong>Match Score:</strong> ${result.score}% (${result.suitability})</p>
            <p><strong>Matched Skills:</strong> ${result.matchedSkills.join(', ') || 'None'}</p>
            <p style="color: red;"><strong>Missing Skills:</strong> ${result.missingSkills.join(', ') || 'None'}</p>
        `;

        container.appendChild(card);
    });
}