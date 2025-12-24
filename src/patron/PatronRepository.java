package patron;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatronRepository {
    private List<Patron> patrons = new ArrayList<>();
    
    public void addPatron(Patron patron) {
        if (patron == null || patron.getMemberId() == null || patron.getMemberId().isEmpty()) {
            throw new IllegalArgumentException("Invalid patron");
        }
        patrons.add(patron);
    }
    
    public Optional<Patron> findByMemberId(String memberId) {
        if (memberId == null || memberId.isEmpty()) {
            return Optional.empty();
        }
        return patrons.stream()
            .filter(p -> p.getMemberId().equals(memberId))
            .findFirst();
    }
    
    public Optional<Patron> findByName(String name) {
        if (name == null || name.isEmpty()) {
            return Optional.empty();
        }
        return patrons.stream()
            .filter(p -> p.getName().equalsIgnoreCase(name))
            .findFirst();
    }
    
    public List<Patron> getAllPatrons() {
        return new ArrayList<>(patrons);
    }

      // FIX: Add update functionality
    public boolean updatePatron(String memberId, Patron updatedPatron) {
        Optional<Patron> existingPatron = findByMemberId(memberId);
        if (existingPatron.isPresent()) {
            int index = patrons.indexOf(existingPatron.get());
            patrons.set(index, updatedPatron);
            
            return true;
        }
        
        return false;
    }
}