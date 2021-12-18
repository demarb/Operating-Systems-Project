# Operating-Systems-Project

Problem Overview:
An OS maintains a shared list of ten (10) integer elements and all processes perform one of three
tasks on this shared list of integer elements. A process can be executing any of the following tasks:
    i. Adding two records in the list and saving results in the second location. Result of
    addition must also be displayed.
    ii. Coping content from one location in list and using it to replace another location. Previous
    and updated value of replaced location must be displayed.
    iii. Display a record from the list
    Multiple processes can generate the same task. Each task has an initial priority; 1 being the highest.
    Adding - priority of 1 Coping - priority of 2 Display - priority of 3
    Input
Two set of inputs required:
    1. Upon start of the simulation the user should set the number of processes to be simulated,
    each requiring at most two I/O requests for integer element(s). The minimum number of
    processes that can be entered is ten (10) and the maximum is thirty (30).
    2. The second input expected from user is the starting position in the list of integers, where
    scanning through list is initially an upward movement.
    Scheduling

This OS can have five (5) active processes at a time based on FCFS scheduling, but an active
process must attain lock on all records required in shared list before executing task. Locking
of records is based on priority. Once a process has a lock on all required integers from
shared list the process should (1) execute its task and (2) unlock integer to terminate.
Constraint: Once a process terminates, the priority of remaining active tasks should be increased.
Data Structure

The process data structure should have the following characteristics:
    1) PID (a unique randomized integer)
    2) Task (a randomly select option of the three above)
    3) Data (indexes of integer(s) accessed)
    4) Start time (system time)
    5) End time (system time)
    6) Attempts (number of tries to lock shared list of integers)
    
The data structure representing the integer element is defined as follows:
    i. Value for integer
    ii. Key for the integer

In a group of five (5), you are required to develop a scheduling algorithm based on description
provided above and simulate such within timetabled interview session.

HINT: scheduling algorithm can be a merger of process and disk scheduling done in class.
When the simulation ends you should provide two reports:
    1. stating the sequence in which the records were accessed
    2. displaying the details of all the processes in a tabular format
    
Each group can implement the OS in any programming language of choice. 
