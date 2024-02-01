package data
data class Quiz(val name: String, val questions: List<Question>){
    var maxScore: Int = questions.count()
    var highScore = 0
}

data class Question(val text: String, val options: List<String>, val correctAnswerIndex: Int)

val ITServiceManagementQuiz = Quiz(
    name = "IT Service Management",
    questions = listOf(
        Question("What does ITIL stand for?", listOf("Information Technology Infrastructure Library", "International Technology Integrated Learning", "Informational Technology Integration Level", "Integrated Technology and Information Library"), 0),
        Question("Which process's purpose is to minimize the negative impact of incidents by restoring normal service operation as quickly as possible?", listOf("Change Management", "Incident Management", "Problem Management", "Service Level Management"), 1),
        Question("Which ITIL process is responsible for controlling, recording, and reporting on the relationships between components of the IT infrastructure?", listOf("Configuration Management", "Capacity Management", "Financial Management", "Availability Management"), 0),
        Question("What is the primary focus of business continuity management?", listOf("Designing and implementing IT services", "Maintaining and improving business resilience", "Financial planning and cost control", "Human resource management"), 1),
        Question("What is a primary objective of Change Management?", listOf("To ensure that all changes are recorded", "To deliver and manage IT services at agreed levels", "To enable quick and effective access to standard services", "To ensure that changes are made with minimum disruption to services"), 3),
        Question("Which is a set of specialized organizational capabilities for delivering value to customers in the form of services?", listOf("Resource Management", "Service Management", "Change Management", "Problem Management"), 1),
        Question("Which process is responsible for managing risks that could seriously affect IT services?", listOf("IT Service Continuity Management", "Service Desk", "Incident Management", "Service Level Management"), 0),
        Question("What does the 'R' in RACI matrix stand for?", listOf("Recovery", "Relevant", "Responsible", "Resource"), 2),
        Question("What is the main goal of Knowledge Management?", listOf("To share perspectives, ideas, experience, and information", "To control expenses and budgeting", "To manage human resources", "To facilitate infrastructure acquisition"), 0),
        Question("In which document would you find the detailed description of a process?", listOf("Service Level Agreement", "Operational Level Agreement", "Process Manual", "Service Catalog"), 2)
    )
)

val ITInfrastructureQuiz = Quiz(
    name = "IT Infrastructure",
    questions = listOf(
        Question("What does RAID stand for in IT infrastructure?", listOf("Redundant Array of Independent Disks", "Random Access Integrated Devices", "Rapid Application Implementation and Deployment", "Reliable Array of Integrated Disks"), 0),
        Question("Which of these is a primary component of a basic IT infrastructure?", listOf("CRM Software", "Network Switch", "Marketing Plan", "Sales Force"), 1),
        Question("What is the main purpose of a load balancer in IT infrastructure?", listOf("Balancing power load across devices", "Distributing network traffic across multiple servers", "Managing software deployment", "Optimizing the database performance"), 1),
        Question("What does DHCP stand for?", listOf("Dynamic Host Configuration Protocol", "Distributed Host Control Program", "Direct HTTP Control Protocol", "Dynamic HTTP Control Program"), 0),
        Question("Which protocol is commonly used for securely connecting to network devices remotely?", listOf("HTTP", "SSH", "FTP", "SMTP"), 1),
        Question("In cloud computing, what does IaaS stand for?", listOf("Internet as a Service", "Integration as a Service", "Infrastructure as a Service", "Information as a Service"), 2),
        Question("What is the main function of a firewall in IT infrastructure?", listOf("Data Analysis", "User Authentication", "Traffic Filtering and Protection", "Internet Connectivity"), 2),
        Question("Which device interconnects multiple network segments at the data link layer?", listOf("Router", "Switch", "Modem", "Repeater"), 1),
        Question("What is typically used for inter-process communication in a microservices architecture?", listOf("Shared Database", "RESTful APIs", "Direct Linking", "Static Libraries"), 1),
        Question("Which technology is primarily used to virtualize physical servers into multiple different virtual servers?", listOf("Docker", "Kubernetes", "Hypervisor", "Node.js"), 2)
    )
)

