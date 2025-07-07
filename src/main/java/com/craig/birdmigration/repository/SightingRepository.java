@Repository
public interface SightingRepository extends JpaRepository<Sighting, Long> {
    List<Sighting> findByObserverName(String observerName);
}
